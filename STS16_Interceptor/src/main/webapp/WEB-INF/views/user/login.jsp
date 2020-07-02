<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
</head>
<body>
<c:if test="${url_prior_login != null }">
	<script type="text/javascript">
		alert("해당 주소로 이동하려면 로그인이 필요합니다.");
	</script>
</c:if>
<h2>로그인</h2>
<form action="loginOk" method="POST">
id : <input name="id" required/><br>
pw : <input name="pw" required/><br>
<input type="submit" value="로그인"/>
</form>
</body>

</html>