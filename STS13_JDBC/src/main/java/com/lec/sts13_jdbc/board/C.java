package com.lec.sts13_jdbc.board;

import org.springframework.jdbc.core.JdbcTemplate;

public class C {
	/**
	 * 스프링 컨테이너에 생성된 JdbcTemplate 을 받아와서
	 * 언제 어디서든 원할 때, 가져다 쓸 수 있도록 public static 설정
	 */
	public static JdbcTemplate template;
	
	/**
	 * 게시글 관련 Query 문 준비
	 */
	// 모든 글 읽어오기
	public static final String SQL_WRITE_SELECT = 
			"SELECT wr_uid \"uid\", wr_subject subject, wr_content content, wr_name name, wr_viewcnt ciewcnt, wr_regdate regDate"
			+ " FROM test_write ORDER BY wr_uid DESC";
	// 해당 uid의 글 읽어오기
	public static final String SQL_WRITE_SELECT_BY_UID = 
			"SELECT wr_uid \"uid\", wr_subject subject, wr_content content, wr_name name, wr_viewcnt ciewcnt, wr_regdate regDate"
			+ " FROM test_write WHERE wr_uid = ?";
	// 글 추가
	public static final String SQL_INSERT = 
			"INSERT INTO test_write (wr_uid, wr_subject, wr_content, wr_name)"
			+ " VALUES(test_write_seq.nextval, ?, ?, ?)";
	// 글 수정
	public static final String SQL_WRITE_UPDATE = 
			"UPDATE test_write SET wr_subject = ?, wr_content = ? WHERE wr_uid = ?";
	// 글 삭제
	public static final String SQL_WRITE_DELETE_BY_UID = 
			"DELETE FROM test_write WHERE wr_uid = ?";
	// 조회수 증가
	public static final String SQL_WRITE_INC_VIEWCNT = 
			"UPDATE test_write SET wr_viewcnt = wr_viewcnt + 1 WHERE wr_uid = ?";

}
