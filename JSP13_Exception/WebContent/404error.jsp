<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% response.setStatus(HttpServletResponse.SC_OK); %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>404 에러</title>
</head>
<body>
<h1>요청한 페이지가 존재하지 않습니다.</h1>
<button onclick="location.href='newpage.jsp'">나가기</button>
<hr>
<img src="https://previews.123rf.com/images/lucian3d/lucian3d1504/lucian3d150400169/39251980-%EB%8F%8B%EB%B3%B4%EA%B8%B0%EA%B0%80%EC%9E%88%EB%8A%94-3d-%EC%BA%90%EB%A6%AD%ED%84%B0.jpg" alt="" />
</body>
</html>