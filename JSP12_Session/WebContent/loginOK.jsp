<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%!
public static final String ADMIN_ID = "admin";
public static final String ADMIN_PW = "1234";
%>
<%
String userid = request.getParameter("userid");
String pw = request.getParameter("pw");
if(userid.equalsIgnoreCase(ADMIN_ID) && pw.equals(ADMIN_PW)){
	session.setAttribute("userid", userid);
%>
<script>
alert("로그인 성공!");
</script>
<%
} else {
	session.removeAttribute("userid");
%>
<script>
alert("로그인 실패...")
</script>
<%
}
%>
<script>
location.href = "login.jsp";
</script>