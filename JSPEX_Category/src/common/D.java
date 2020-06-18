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
	public static final String SQL_CATEGORY_BY_DEPTH_N_PARENT =
			"SELECT ca_uid \"uid\", ca_name \"name\", ca_depth \"depth\", ca_parent \"parent\", ca_order \"order\" "
			+ "FROM TEST_CATEGORY "
			+ "WHERE CA_DEPTH = ? AND CA_PARENT = ? "
			+ "ORDER BY CA_ORDER ASC";

	public static final String SQL_CATEGORY_BY_DEPTH_1 =
			"SELECT ca_uid \"uid\", ca_name \"name\", ca_depth \"depth\", ca_parent \"parent\", ca_order \"order\" "
			+ "FROM TEST_CATEGORY "
			+ "WHERE CA_DEPTH = 1 "
			+ "ORDER BY CA_ORDER ASC";

} // end Class