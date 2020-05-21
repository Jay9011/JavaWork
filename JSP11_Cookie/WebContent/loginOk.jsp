<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%!
public static final String ADMIN_ID = "admin";
public static final String ADMIN_PW = "1234";
%>
<%
String userid = request.getParameter("userid");
String pw = request.getParameter("pw");
String cookieName = "userid";
String cookieValue = userid;

// id 와 pw 일치하면 로그인 성공 --> 쿠키 생성
if(ADMIN_ID.equalsIgnoreCase(userid) && ADMIN_PW.equals(pw)){
	out.print("<script>");
	out.print("alert('로그인 성공')");
	out.print("</script>");

	Cookie cookie = new Cookie(cookieName, cookieValue);
	cookie.setMaxAge(2 * 30);
	response.addCookie(cookie);
} else {
	out.print("<script>");
	out.print("alert('로그인 실패')");
	out.print("</script>");

	Cookie cookie = new Cookie(cookieName, cookieValue);
	cookie.setMaxAge(0);	// 기존에 있었더라고 삭제한다.
	response.addCookie(cookie);
} // end if
%>
<script>
location.href = "login.jsp";
</script>