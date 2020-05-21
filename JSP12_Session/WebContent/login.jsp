<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>login 페이지</title>
</head>
<body>
<%!
String sessionName = "userid";
%>
<%-- 현재 로그인 상태인지, 즉 로그인 세션(name이 'userid'인 세션값)이 있는지 확인 --%>
<%if(session.getAttribute(sessionName) == null){%>
<h2>로그인 상태가 아닙니다.</h2>
<form action="loginOK.jsp">
id:<input type="text" name="userid"><br>
pw:<input type="password" name="pw"><br>
<input type="submit" value="로그인" />
</form>
<%} else { %>
<h2>로그인 되었습니다.</h2>
<form action="logout.jsp">
<input type="submit" value="로그아웃" />
</form>
<%}%>

</body>
</html>