<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.lec.beans.WriteDTO" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>EL Request</title>
</head>
<body>
<%
	request.setAttribute("myage", 8);
	request.setAttribute("mydto", new WriteDTO(100, "제목", "내용", "작성자", 3));
	pageContext.setAttribute("myage", "흠~");
%>
<!-- Scope 우선순위 : page - request - session - application -->
${myage }<br>
${requestScope.myage }<br>
<hr />
${mydto }<br> <!-- toString() 값 -->
${mydto.uid }<br>
${mydto.subject }<br>
${mydto.content }<br>
<hr />
<%= ((WriteDTO)request.getAttribute("mydto")).getUid() %><br>
<%= ((WriteDTO)request.getAttribute("mydto")).getSubject() %><br>
<%= ((WriteDTO)request.getAttribute("mydto")).getContent() %><br>
</body>
</html>