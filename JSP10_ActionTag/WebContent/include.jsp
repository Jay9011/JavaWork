<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>include</title>
<link rel="stylesheet" href="CSS/style.css">
</head>
<body>
<!-- Action Tag -->
<h3>지금의 페이지는 include 페이지 입니다.</h3>
<jsp:include page="sub.jsp"/>
<p>위 라인의 내용은 sub 페이지의 내용입니다.</p>
<hr>
<!-- Directive -->
<h3>지금의 페이지는 include 페이지 입니다.</h3>
<%@ include file="sub.jsp" %>
<p>위 라인의 내용은 sub 페이지의 내용입니다.</p>
<hr>
<%!
// 변수 선언
String name = "홍길동";
int age = 33;
%>
<%@ include file="sub2.jsp" %>
<%-- <jsp:include page="sub2.jsp"/> --%>
<hr>
<jsp:include page="sub3.jsp">
	<jsp:param value='<%= URLEncoder.encode(name, "UTF-8") %>' name="name"/>
	<jsp:param value="<%= age %>" name="age"/>
</jsp:include>
</body>
</html>