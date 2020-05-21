<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>subParam</title>
</head>
<body>
<%! String id, pw; %>
<%
id = request.getParameter("id");
pw = request.getParameter("pw");
%>
<p>현재 페이지는 subParam</p>
아이디: <%= id %><br>
비밀번호: <%= pw %><br>
</body>
</html>