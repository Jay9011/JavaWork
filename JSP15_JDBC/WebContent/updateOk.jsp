<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %><%-- JDBC 관련 import --%>
<%	// parameter 받아오기
	request.setCharacterEncoding("utf-8"); // 한글 인코딩
	int uid = Integer.parseInt(request.getParameter("uid"));
	String subject = request.getParameter("subject");
	String content = request.getParameter("content");
	// ※ 이 단계에서 parameter 검증 필요
%>
<%!
	// JDBC 관련 기본 객체 변수
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;	// SELECT 결과, executeQuery()
	int cnt = 0;			// DML 결과, executeUpdate()

	// Connection 에 필요한 값 세팅
	final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	final String USERID = "SCOTT0316";
	final String USERPW = "TIGER0316";
%>
<%!
	// 쿼리문 준비
	final String SQL_WRITE_UPDATE =
		"UPDATE test_write SET wr_subject = ?, wr_content = ? WHERE wr_uid = ?";
%>
<%
	try {
		Class.forName(DRIVER);
		out.print("드라이버 로딩 성공" + "<br>");
		conn = DriverManager.getConnection(URL, USERID, USERPW);
		out.print("conn 성공" + "<br>");

		// 트렌잭션 실행
		pstmt = conn.prepareStatement(SQL_WRITE_UPDATE);
		pstmt.setString(1, subject);
		pstmt.setString(2, content);
		pstmt.setInt(3, uid);

		cnt = pstmt.executeUpdate();
	} catch (Exception e) {
		e.printStackTrace();
		// 예외처리
	} finally {
		// 리소스 해제
		try {
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
%>
<%-- 위 트랜젝션이 마무리 되면 페이지 보여주기 --%>
<% if(cnt == 0) {%>
	<script>
		alert("수정 실패!!!");
		history.back();		// 브라우저가 기억하는 직전 페이지로 이동
	</script>
<%} else {%>
	<script>
		alert("수정 성공.");
		location.href = "view.jsp?uid=<%=uid%>";
	</script>
<%}%>