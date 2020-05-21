<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<% response.setStatus(200); %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>에러 안내</title>
</head>
<body style="text-align:center;">
<h1>에러 나타남!!!!</h1>
예외 타입은 : <%= exception.getClass().getName() %><br>
예외 메세지는 : <%= exception.getMessage() %><br>
<hr>
<img src="https://post-phinf.pstatic.net/MjAyMDAxMDJfMjE0/MDAxNTc3OTU1NDUwMTk2.CYPuT2TFBYa15mnZDOReu5YQErQHmO3juTjWXN1sg8Ag.3LRsWxTGKaYOzCFDHm6-stMK0BNTTSLlaKz2wQ1l5c4g.JPEG/62246832_425639158281486_1528361062506865852_n.jpg?type=w1200" alt="갸우뚱" />
</body>
</html>