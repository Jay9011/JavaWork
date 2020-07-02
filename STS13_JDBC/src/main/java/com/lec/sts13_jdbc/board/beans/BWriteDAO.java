package com.lec.sts13_jdbc.board.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.lec.sts13_jdbc.board.C;

public class BWriteDAO {
	JdbcTemplate template;

	public BWriteDAO() {
		this.template = C.template;
	}

	public BWriteDAO(JdbcTemplate template) {
		super();
		this.template = template;
	} // end BWriteDAO()
	

	// 전체 SELECT
	public ArrayList<BWriteDTO> select(){
		return (ArrayList<BWriteDTO>) template.query(C.SQL_WRITE_SELECT, 
									new BeanPropertyRowMapper<BWriteDTO>(BWriteDTO.class));
	}
	
	public int insert(final BWriteDTO dto) {
		return 
				
		/**
		 * 1. update() + PreparedStatementSetter()
		 */
//		template.update(C.SQL_INSERT, new PreparedStatementSetter() {
//			@Override
//			public void setValues(PreparedStatement ps) throws SQLException {
//				ps.setString(1, dto.getSubject());
//				ps.setString(2, dto.getContent());
//				ps.setString(3, dto.getName());
//			} // end setValues()
//		}); // end template.update()
				
		/**
		 * 2. update() + PreparedStatementCreator()		
		 */
		template.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt = con.prepareStatement(C.SQL_INSERT);
				pstmt.setString(1, dto.getSubject());
				pstmt.setString(2, dto.getContent());
				pstmt.setString(3, dto.getName());
				return pstmt;
			} // end createPreparedStatement()
		}); // end template.update()
	} // end insert()

	/**
	 * 글 읽어오기
	 * @param uid
	 * @return BWriteDTO
	 */
	public BWriteDTO readByUid(final int uid) {
		BWriteDTO dto = null;
		/**
		 * 조회수 증가
		 */
		template.update(C.SQL_WRITE_INC_VIEWCNT, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, uid);
			} // end setValues()
		}); // end template.update
		List<BWriteDTO> list = 
				/**
				 * 글 읽기
				 */
				template.query(C.SQL_WRITE_SELECT_BY_UID,
						new PreparedStatementSetter() {
							@Override
							public void setValues(PreparedStatement ps) throws SQLException {
								ps.setInt(1, uid);
							} // end setValues()
						},
						new BeanPropertyRowMapper<BWriteDTO>(BWriteDTO.class)); // end template.query

		if(list.size() > 0) dto = list.get(0);  // List<T> 으로 리턴하기 때문에 첫 번째 결과만 리턴시켜준다.
		
		return dto;
	} // end readByUid()
	
	/**
	 * 조회수 증가 없이 데이터를 불러오기
	 * @param uid
	 * @return BWriteDTO
	 */
	public BWriteDTO selectByUid(final int uid) {
		BWriteDTO dto = null;
		List<BWriteDTO> list = 
				/**
				 * 글 읽기
				 */
				template.query(C.SQL_WRITE_SELECT_BY_UID,
						new PreparedStatementSetter() {
							@Override
							public void setValues(PreparedStatement ps) throws SQLException {
								ps.setInt(1, uid);
							} // end setValues()
						},
						new BeanPropertyRowMapper<BWriteDTO>(BWriteDTO.class)); // end template.query

		if(list.size() > 0) dto = list.get(0);  // List<T> 으로 리턴하기 때문에 첫 번째 결과만 리턴시켜준다.
		
		return dto;
	} // end selectByUid()
	
	/**
	 * 글 수정하기
	 * @param dto
	 * @return cnt
	 */
	public int update(final BWriteDTO dto) {
		int cnt = 0;
		
		cnt = 
		template.update(C.SQL_WRITE_UPDATE, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, dto.getSubject());
				ps.setString(2, dto.getContent());
				ps.setInt(3, dto.getUid());
			} // end setValues()
		}); // end template.update()
		
		return cnt;
	} // end update()
	
	/**
	 * 글 삭제하기
	 * @param uid
	 * @return cnt
	 */
	public int deleteByUid(final int uid) {
		int cnt = 0;
		
		cnt = 
				template.update(C.SQL_WRITE_DELETE_BY_UID, new PreparedStatementSetter() {
					@Override
					public void setValues(PreparedStatement ps) throws SQLException {
						ps.setInt(1, uid);
					} // end setValues()
				}); // end template.update()
		
		return cnt;
	} // end deleteByUid()
	
} // end Class
