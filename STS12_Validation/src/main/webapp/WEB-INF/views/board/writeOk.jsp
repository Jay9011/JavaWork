<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
</head>
<body>
uid : ${w.uid }<br>
작성자 : ${w.name }<br>
제목 : ${w.subject }<br>
<button onclick="history.back()">돌아가기</button>
</body>
</html>