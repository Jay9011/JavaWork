package phonebook06.db;

import java.io.Closeable;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// CONTROLLER 객체
//	어플리케이션의 동작, 데이터 처리(CRUD), (Business Logic 담당)

public class PhonebookManager implements Pb, Closeable {

	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	// Singleton 적용
	private PhonebookManager() {
	
		// JDBC 프로그래밍
		// 	클래스 로딩
		//	연결 Connection
		//	Statement (필요하다면) 생성
		try {
			Class.forName(DRIVER);
			System.out.println("드라이버 로딩 성공");
			conn = DriverManager.getConnection(URL, USER, PASSWD);
			System.out.println("Connection 성공");
			
		} catch (ClassNotFoundException e) {
			throw new PhonebookException("드라이버를 찾지 못했습니다 : " + e.toString(), ERR_CLASSNOTFOUND);
		} catch (SQLException e) {
			throw new PhonebookException("서버에 연결하지 못했습니다 : " + e.toString(), ERR_SQL);
		}
		
	}
	
	private static PhonebookManager instance = null;
	public static PhonebookManager getInstance() {
		if(instance == null) {
			instance = new PhonebookManager();
		}
		return instance;
	} // end getInstance()
	
	// 전화번호부 생성 등록
	@Override
	public int insert(String name, String phoneNum, String memo) {
		
		// 매개변수 검증 : 이름 필수
		if(name.trim().length() == 0 || name == null) {
			throw new PhonebookException("insert() 이름 입력 오류 : ", Pb.ERR_EMPTY_STRING);
		}

		int cnt = 0;
		
		// DML INSERT 구문, 정수리턴
		// SQL_INSERT 사용하여 INSERT
		// PreparedStatement 사용...
		try {
			pstmt = conn.prepareStatement(SQL_INSERT);
			pstmt.setString(1, name);
			pstmt.setString(2, phoneNum);
			pstmt.setString(3, memo);
			
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cnt;
	}

	@Override
	public PhonebookModel[] selectAll() {
		
		List<PhonebookModel> list = new ArrayList<PhonebookModel>();
		// SQL_SELECT_ALL 사용
		try {
			pstmt = conn.prepareStatement(SQL_SELECT_ALL);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String dateS = new SimpleDateFormat("yyyy-MM-dd").format(rs.getDate(COL_LABEL_REGDATE)) + " " + new SimpleDateFormat("HH:mm:ss").format(rs.getTime(COL_LABEL_REGDATE));
				Date date = null;
				try {
					date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateS);
				} catch (ParseException e) {
					e.getMessage();
					date = new Date(0);
				}
				list.add(new PhonebookModel(rs.getInt(COL_LABEL_UID), 
						rs.getString(COL_LABEL_NAME), 
						rs.getString(COL_LABEL_PHONENUM), 
						rs.getString(COL_LABEL_MEMO), date
						));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(rs != null) rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list.toArray(new PhonebookModel[list.size()]);
	}

	// 특정 uid의 데이터 검색 리턴
	// 못찾으면 null 리턴
	@Override
	public PhonebookModel selectByUid(int uid) {
		try {
			pstmt = conn.prepareStatement(SQL_SELECT_UID);
			pstmt.setInt(1, uid);
			if(pstmt.executeUpdate() != 0) {
				return new PhonebookModel();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	} // end selectByUid(int)

	@Override
	public int updateByUid(int uid, String name, String phoneNum, String memo) {
		
		// 매개변수 검증
		if (uid < 1 ) {
			throw new PhonebookException("update() uid 오류 : " + uid, Pb.ERR_UID);
		}
		if(name == null || name.trim().length() == 0) {
			throw new PhonebookException("update() 이름 입력 오류 : ", Pb.ERR_EMPTY_STRING);
		}
		
		int cnt = 0;
		
		// SQL_UPDATE_BY_UID 사용
		try {
			pstmt = conn.prepareStatement(SQL_UPDATE_BY_UID);
			pstmt.setString(1, name);
			pstmt.setString(2, phoneNum);
			pstmt.setString(3, memo);
			pstmt.setInt(4, uid);
			
			cnt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public int deleteByUid(int uid) {
		
		// 매개변수 검증
		if(uid < 1)
			throw new PhonebookException("deleteByUid() uid 오류 : " + uid, Pb.ERR_UID);;
		
		int cnt = 0;
		
		// SQL_DELETE_BY_UID 사용
		try {
			pstmt = conn.prepareStatement(SQL_DELETE_BY_UID);
			pstmt.setInt(1, uid);
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public int searchUid() {
		// 필요 없음
		return 0;
	}
	
	// 현재 데이터중 가장 큰 uid 값을 찾아서 리턴
	private int getMaxUid() {
		int maxUid = 0;

		// 옵션
		try {
			String sql = "SELECT MAX(" + COL_LABEL_UID + ") as MAX FROM " + TBL_NAME;
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			rs.next();
			maxUid = rs.getInt("MAX");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return maxUid;
	}
	
	@Override
	public void close() throws IOException {
		
		// ResultSet
		// Statement
		// Connection
		// 들 close() 시킬 것!
		try {
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(stmt != null) stmt.close();
			if(conn != null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

} // end class
// 예외 Class 정의
// 예외가 발생하면 '에러코드' + '에러메세지'를 부여하여 관리하는게 좋다.
class PhonebookException extends RuntimeException {
	private int errCode = Pb.ERR_GENERIC;
	
	public PhonebookException() {
		super("Phonebook 예외 발생");
	}
	
	public PhonebookException(String msg) {
		super(msg);
	}
	
	public PhonebookException(String msg, int errCode) {
		super(msg);
		this.errCode = errCode;
	}

	// Throwable 의 getMessage 를 오버라이딩 가능
	@Override
	public String getMessage() {
		String msg = "ERR-" + errCode + "]" + Pb.ERR_STR[errCode] + " " + super.getMessage(); 
		return msg;
	}
}
