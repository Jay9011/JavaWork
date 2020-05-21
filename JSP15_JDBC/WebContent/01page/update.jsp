<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %><%-- JDBC 관련 import --%>
<%@ page import="java.text.SimpleDateFormat" %>
<% // parameter 받아오기
	int uid = Integer.parseInt(request.getParameter("uid"));
	// ※ 이 단계에서 parameter 검증 필요

	int curPage = 1;

	String pageParam = request.getParameter("page");
	if(pageParam != null && !pageParam.trim().equals("")){
		try {
			int p = Integer.parseInt(pageParam);
			if(p > 0){
				curPage = p;
			}
		} catch (NumberFormatException e){
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
	final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	final String USERID = "SCOTT0316";
	final String USERPW = "TIGER0316";
%>
<%!
	// 쿼리문 준비
	final String SQL_WRITE_SELECT_BY_UID =	// 해당 uid의 글 읽어오기
			"SELECT * FROM test_write WHERE wr_uid = ?";
%>
<%
	String name = "";
	String subject = "";
	String content = "";
	String regdate = "";
	int viewcnt = 0;
%>
<%
	try {
		Class.forName(DRIVER);
		out.print("드라이버 로딩 성공" + "<br>");
		conn = DriverManager.getConnection(URL, USERID, USERPW);
		out.print("conn 성공" + "<br>");

		// 트렌잭션 실행
		pstmt = conn.prepareStatement(SQL_WRITE_SELECT_BY_UID);
		pstmt.setInt(1, uid);
		rs = pstmt.executeQuery();

		// 한 개의 레코드만 select 된다.
		if(rs.next()){
			subject = rs.getString("wr_subject");
			content = rs.getString("wr_content");
			if(content == null) content = "";		// null 처리
			name = rs.getString("wr_name");
			viewcnt = rs.getInt("wr_viewcnt");
			Date d = rs.getDate("wr_regdate");
			Time t = rs.getTime("wr_regdate");
			regdate = "";
			if(d != null){
				regdate = new SimpleDateFormat("yyyy-MM-dd").format(d) + " "
						+ new SimpleDateFormat("hh:mm:ss").format(t);
			}
		} else {
			// wr_uid 값의 레코드가 없는 경우
%>
		<script>
			alert("해당 정보가 삭제되었거나 존재하지 않습니다.");
			history.back();
		</script>
<%
			return;	// 더 이상 JSP 프로세싱을 하지 않고 종료
		} // end if
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
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>수정 <%=subject%></title>
</head>
<script>
function chkSubmit(){
	frm = document.forms['frm'];
	var subject = frm['subject'].value.trim();

	if(subject == ""){
		alert("제목은 반드시 작성해야 합니다.");
		frm['subject'].focus();
		return false;
	}
	return true;
}
</script>
<body>
<h2>수정</h2>
<form action="updateOk.jsp?page=<%=curPage%>" name="frm" method="post" onsubmit="return chkSubmit()">
<input type="hidden" name="uid" value="<%=uid%>"/>
작성자 : <%=name%><br>
제목 : <input type="text" name="subject" value="<%=subject%>" /><br>
등록일 : <%=regdate%><br>
조회수 : <%=viewcnt%><br>
<hr>
내용 :
<div>
<textarea name="content" cols="30" rows="10"><%=content%></textarea><br>
</div>
<hr><br>
<input type="submit" value="수정" />
<button onclick="history.back()">이전으로</button>
<button onclick="location.href='list.jsp?page=<%=curPage%>'">목록보기</button>
</form>
</body>
</html>