package com.lec.sts13_jdbc.board.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

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

	// 글 읽어오기
	public ArrayList<BWriteDTO> readByUid(final int uid) {
		return
				(ArrayList<BWriteDTO>) template.query(C.SQL_WRITE_SELECT_BY_UID,
						new PreparedStatementSetter() {
							@Override
							public void setValues(PreparedStatement ps) throws SQLException {
								ps.setInt(1, uid);
							} // end setValues()
						},
						new BeanPropertyRowMapper<BWriteDTO>(BWriteDTO.class));
	} // end readByUid()
} // end Class
