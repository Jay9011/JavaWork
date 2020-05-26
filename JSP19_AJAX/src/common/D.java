package common;

/**************************************
 * DB 접속정보, 쿼리문, 테이블명, 컬럼명 등은
 * 별도로 관리하든지
 * XML, 초기화 파라미터 등에서 관리하는 것이 좋다.
 **************************************
 */
public class D {
	// Connection 에 필요한 값 세팅
	public static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	public static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	public static final String USERID = "SCOTT0316";
	public static final String USERPW = "TIGER0316";

	/**
	 * Query 문 준비
	 */
	// 모든 글 읽어오기
	public static final String SQL_WRITE_SELECT = "SELECT * FROM test_write ORDER BY wr_uid DESC";
	// 해당 uid의 글 읽어오기
	public static final String SQL_WRITE_SELECT_BY_UID = "SELECT * FROM test_write WHERE wr_uid = ?";
	// 글 추가
	public static final String SQL_INSERT = "INSERT INTO test_write (wr_uid, wr_subject, wr_content, wr_name) "
			+ "VALUES(test_write_seq.nextval, ?, ?, ?)";
	// 글 수정
	public static final String SQL_WRITE_UPDATE = "UPDATE test_write SET wr_subject = ?, wr_content = ? WHERE wr_uid = ?";
	// 글 삭제
	public static final String SQL_WRITE_DELETE_BY_UID = "DELETE FROM test_write WHERE wr_uid = ?";
	// 조회수 증가
	public static final String SQL_WRITE_INC_VIEWCNT = "UPDATE test_write SET wr_viewcnt = wr_viewcnt + 1 WHERE wr_uid = ?";

}
