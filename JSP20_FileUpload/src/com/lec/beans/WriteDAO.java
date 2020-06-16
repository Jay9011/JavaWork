package com.lec.beans;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import common.D;

/**
 * @DAO : Data Access Object
 *      DB에 접속하여 트랜잭션을 수행하는 객체
 *
 *      다루는 데이터 소스의 종류에 따라 DAO는 여러개 정의 사용 가능
 */
public class WriteDAO {
	// JDBC 관련 기본 객체 변수
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null; // SELECT 결과, executeQuery()

	// DAO 객체가 생성될 때 Connection 도 생성된다.
	public WriteDAO() {
		try {
			Class.forName(D.DRIVER);
			conn = DriverManager.getConnection(D.URL, D.USERID, D.USERPW);
			System.out.println("WriteDAO 생성, 데이터 베이스 연결!");
		} catch (Exception e) {
			e.printStackTrace();
		}

	} // WriteDAO()

	// DB 자원 반납 메소드,
	public void close() throws SQLException {
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		if(stmt != null) stmt.close();
		if(conn != null) conn.close();
		System.out.println("자원 반납(ResultSet, PreparedStatement, Statement, Connection)");
	} // end close()

	/**
	 *  새 글 작성 <-- DTO
	 */
	public int insert(WriteDTO dto) throws SQLException {
		String subject = dto.getSubject();
		String content = dto.getContent();
		String name = dto.getName();

		int cnt = this.insert(subject, content, name);
		return cnt;
	}

	/**
	 *  새 글 작성 <-- 제목, 내용, 작성자
	 */
	public int insert(String subject, String content, String name) throws SQLException {
		int cnt = 0;

		try {
			pstmt = conn.prepareStatement(D.SQL_INSERT);
			pstmt.setString(1, subject);
			pstmt.setString(2, content);
			pstmt.setString(3, name);

			cnt = pstmt.executeUpdate();
		} finally {
			close();
		}

		return cnt;
	}

	/**
	 * 	새 글 작성 <-- 제목, 내용, 작성자
	 * 	<-- 첨부파일(들)
	 */
	public int insert(String subject, String content, String name
			// 이미 파일은 저장되어 있다.
			, List<String> originalFileNames	// 원본 파일명(들)
			, List<String> fileSystemNames		// 저장된 파일명(들)
			) throws SQLException {
		int cnt = 0;
		int uid = 0;	// INSERT 된 글의 wr_uid 값
		try {
			// 자동 생성된 컬럼의 이름(들)이 담긴 배열 준비 (auto-generated keys)
			String[] generatedCols = {"wr_uid"};

			// Statement 나 PreparedStatement 생성시 두번째 매개변수로 auto-generated keys 배열 넘겨줌
			pstmt = conn.prepareStatement(D.SQL_INSERT, generatedCols);
			pstmt.setString(1, subject);
			pstmt.setString(2, content);
			pstmt.setString(3, name);

			cnt = pstmt.executeUpdate();

			// auto-generated keys 값 꺼내오기
			rs = pstmt.getGeneratedKeys();
			if(rs.next()) {
				uid = rs.getInt(1);	// 첫 번째 컬럼(wr_uid)
			}

			pstmt.close();
			// 첨부파일(들)의 정보를 테이블에 INSERT 하기
			pstmt = conn.prepareStatement(D.SQL_FILE_INSERT);
			for (int i = 0; i < originalFileNames.size(); i++) {
				pstmt.setString(1, originalFileNames.get(i));
				pstmt.setString(2, fileSystemNames.get(i));
				pstmt.setInt(3, uid);
				pstmt.executeUpdate();
			}
		} finally {
			close();
		}

		return cnt;
	}

	/**
	 *  ResultSet --> DTO 배열로 리턴
	 */
	public WriteDTO[] createArray(ResultSet rs) throws SQLException {
		WriteDTO[] arr = null;	// DTO 배열

		ArrayList<WriteDTO> list = new ArrayList<WriteDTO>();

		while(rs.next()) {
			int uid = rs.getInt("wr_uid");
			String subject = rs.getString("wr_subject");
			String name = rs.getString("wr_name");
			String content = rs.getString("wr_content");
			int viewCnt = rs.getInt("wr_viewcnt");
			Date d = rs.getDate("wr_regdate");
			Time t = rs.getTime("wr_regdate");

			String regDate = "";
			if(d != null){
				regDate = new SimpleDateFormat("yyyy-MM-dd").format(d) + " "
						+ new SimpleDateFormat("hh:mm:ss").format(t);
			}

			WriteDTO dto = new WriteDTO(uid, subject, content, name, viewCnt);
			dto.setRegDate(regDate);

			list.add(dto);
			System.out.println("list.add(dto) 실행");
		} // end while

		int size = list.size();

		if(size == 0) return null;

		arr = new WriteDTO[size];
		list.toArray(arr);	// List 를 배열[]로 변환

		return arr;
	}


	/**
	 * 	전체 SELECT
	 */
	public WriteDTO[] select() throws SQLException {
		WriteDTO[] arr = null;

		try {
			pstmt = conn.prepareStatement(D.SQL_WRITE_SELECT);
			rs = pstmt.executeQuery();
			arr = createArray(rs);
		} finally {
			close();
		}

		return arr;
	} // end select()


	/**
	 * 	특정 uid 의 글 내용 읽기, 조회수 증가
	 * 	viewCnt 도 1 증가 해야 하고, 읽어와야 한다. --> 트랜잭션 처리
	 */
	public WriteDTO[] readByUid(int uid) throws SQLException {
		int cnt = 0;
		WriteDTO[] arr = null;

		try {
			// 트랜잭션 처리
			// Auto0commit 비활성화
			conn.setAutoCommit(false);

			// 쿼리들 수행
			pstmt = conn.prepareStatement(D.SQL_WRITE_INC_VIEWCNT);
			pstmt.setInt(1, uid);
			cnt = pstmt.executeUpdate();

			pstmt.close();

			pstmt = conn.prepareStatement(D.SQL_WRITE_SELECT_BY_UID);
			pstmt.setInt(1, uid);
			rs = pstmt.executeQuery();

			arr = createArray(rs);
			conn.commit();
		} catch (SQLException e) {
			conn.rollback();
			throw e;
		} finally {
			close();
		}

		return arr;
	} // end readByUid()


	/**
	 * 	특정 uid 의 글만 SELECT
	 */
	public WriteDTO[] selectByUid(int uid) throws SQLException {
		WriteDTO[] arr = null;

		try {
			pstmt = conn.prepareStatement(D.SQL_WRITE_SELECT_BY_UID);
			pstmt.setInt(1, uid);
			rs = pstmt.executeQuery();
			arr = createArray(rs);
		} finally {
			close();
		}

		return arr;
	} // end selectByUid()


	/**
	 * 	특정 uid 의 글 수정 (제목, 내용)
	 */
	public int update(int uid, String subject, String content) throws SQLException {
		int cnt = 0;

		try {
			// 트렌잭션 실행
			pstmt = conn.prepareStatement(D.SQL_WRITE_UPDATE);
			pstmt.setString(1, subject);
			pstmt.setString(2, content);
			pstmt.setInt(3, uid);

			cnt = pstmt.executeUpdate();
		} finally {
			close();
		}

		return cnt;
	} // end update()


	/**
	 * 	특정 uid 글 삭제하기
	 */
	public int deleteByUid(int uid) throws SQLException {
		int cnt = 0;
		try {
			// 트랜잭션 실행
			pstmt = conn.prepareStatement(D.SQL_WRITE_DELETE_BY_UID);
			pstmt.setInt(1, uid);
			cnt = pstmt.executeUpdate();
		} finally {
			close();
		}

		return cnt;
	} // end deleteByUid()

}// end DAO
