<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %><%-- JDBC 관련 import --%>
<%@ page import="java.text.SimpleDateFormat" %>
<%
	int curPage = 1;	// 현재 페이지 (디폴트 1페이지)

	// 현재 몇 페이지인지 parameter 받아오기
	String pageParam = request.getParameter("page");
	if(pageParam != null && !pageParam.trim().equals("")){
		try {
			int p = Integer.parseInt(pageParam);
			if(p > 0){
				curPage = p;
			}
		} catch(NumberFormatException e){
			e.printStackTrace();
		}
	}
%>
<%!
	// JDBC 관련 기본 객체 변수
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;	// SELECT 결과, executeQuery()
	int cnt = 0;			// DML 결과, executeUpdate()

	// Connection 에 필요한 값 세팅
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String uid = "SCOTT0316";
	String upw = "TIGER0316";
%>
<%!
	// 쿼리문 준비
	// final String sql_write_select = "SELECT * FROM TEST_WRITE ORDER BY wr_uid DESC";

	// 페이징을 위한 쿼리문 준비
	// 글 목록 전체 개수 가져오기
	final String SQL_WRITE_COUNT_ALL = "SELECT count(*) FROM test_write";

	// fromRow 부터  pageRows	만큼 SELECT
	// (몇 번째) 부터	(몇 개)	만큼
	final String SQL_WRITE_SELECT_FROM_ROW = "SELECT * FROM " +
			"(SELECT ROWNUM AS RNUM, T.* FROM (SELECT * FROM test_write ORDER BY wr_uid DESC) T) " +
			"WHERE RNUM >= ? AND RNUM < ?";

	// 페이징 관련 세팅 값들
	int writePages = 10;	// 한[페이징]에 몇 개의 '페이지' 를 표현할 것인가?
	int pageRows = 15;		// 한 '페이지'에 몇 개의 글을 보여줄 것인가?
	int totalPage = 0;		// 총 몇 '페이지' 분량인가?
%>
<%
	try {
		Class.forName(driver);
		out.print("드라이버 로딩 성공" + "<br>");
		conn = DriverManager.getConnection(url, uid, upw);
		out.print("conn 성공" + "<br>");

		// 트렌잭션 실행
		pstmt = conn.prepareStatement(SQL_WRITE_COUNT_ALL);
		rs = pstmt.executeQuery();

		if(rs.next()){
			cnt = rs.getInt(1);	// count(*), 전체 글의 개수
		}

		rs.close();
		pstmt.close();

		totalPage = (int)Math.ceil(cnt / (double)pageRows);	// 총 몇 페이지

		int fromRow = (curPage -1) * pageRows + 1;	// 몇 번째 row 부터 보여줘야 하는지

		pstmt = conn.prepareStatement(SQL_WRITE_SELECT_FROM_ROW);
		pstmt.setInt(1, fromRow);
		pstmt.setInt(2, fromRow + pageRows);
		rs = pstmt.executeQuery();
%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>글목록 <%=curPage%>페이지</title>
<style>
table {width: 100%;}
table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
}
</style>
<!-- 페이징 -->
<link rel="stylesheet" href="CSS/common.css" type="text/css" />
<script src="https://kit.fontawesome.com/728e028a62.js" crossorigin="anonymous"></script>
</head>
<body>

	<hr>
	<h2>리스트</h2>
	<h4><%=curPage%>페이지 / <%=totalPage%>페이지 (총 <%=cnt%>개 검색)</h4>
	<table>
		<tr>
			<th>row</th><!-- 행 번호 -->
			<th>UID</th>
			<th>제목</th>
			<th>작성자</th>
			<th>조회수</th>
			<th>등록일</th>
		</tr>
<%
	while(rs.next()){
		out.print("<tr>");
		int rnum = rs.getInt("rnum");	// rownum 받아오기
		int uid = rs.getInt("wr_uid");
		String subject = rs.getString("wr_subject");
		String name = rs.getString("wr_name");
		int viewcnt = rs.getInt("wr_viewcnt");
		Date d = rs.getDate("wr_regdate");
		Time t = rs.getTime("wr_regdate");

		String regdate = "";
		if(d != null){
			regdate = new SimpleDateFormat("yyyy-MM-dd").format(d) + " "
					+ new SimpleDateFormat("hh:mm:ss").format(t);
		}

		out.print("<td>" + rnum + "</td>");
		out.print("<td>" + uid + "</td>");
		out.print("<td><a href='view.jsp?uid=" + uid + "&page=" + curPage+ "'>" + subject + "</a></td>");
		out.print("<td>" + name + "</td>");
		out.print("<td>" + viewcnt + "</td>");
		out.print("<td>" + regdate + "</td>");

		out.print("</tr>");
	} // end while
%>
	</table>
	<br>
	<button onclick="location.href='write.jsp'">신규등록</button>
<%
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
<%-- 위 트랜잭션이 마무리 되면 페이지 보여주기 --%>

<%-- 페이징 --%>
<jsp:include page="pagination.jsp">
	<jsp:param value="<%= writePages %>" name="writePages"/>
	<jsp:param value="<%= totalPage %>" name="totalPage"/>
	<jsp:param value="<%= curPage %>" name="curPage"/>
</jsp:include>

</body>
</html>