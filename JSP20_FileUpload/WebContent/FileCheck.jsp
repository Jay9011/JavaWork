<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.net.*" %>	<%-- URLEncoder 외 --%>

<%-- JSTL을 배웠다면 활용해보자 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<% request.setCharacterEncoding("utf-8"); %>	<%-- post 반식으로 넘길땐, 꼭 인코딩 신경쓰자 --%>

<%-- parameter 받기 : Java --%>
<%
	String[] originalFileNames = request.getParameterValues("originalFileName");
	String[] fileSystemNames = request.getParameterValues("fileSystemName");
	int cnt = originalFileNames.length;
%>

<%-- parameter 받기 : JSTL --%>
<c:set var="originalFileNames" value="${paramValues.originalFileName }"/>
<c:set var="fileSystemNames" value="${paramValues.fileSystemName }"/>
<c:set var="cnt" value="${fn:length(paramValues.originalFileName) }"/>


<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
<style>
	form p{text-decoration:underline;}
	form p:hover{cursor:pointer; color:blue;}
</style>
</head>
<body>
<%-- JAVA 방식 --%>
<h3><%=cnt %>개의 파일 확인</h3>
<ul>
<%
	for(int i = 0; i < cnt; i++){
		out.print("<li>파일: " + (i + 1) + "</li>");
		out.print("<ul>");
		out.print("<li>원본이름: " + originalFileNames[i] + "</li>");
		out.print("<li>파일시스템: " + fileSystemNames[i] + "</li>");
		out.print("</ul>");
	}
%>
</ul>

<%-- JSTL 방식 --%>
<h3>${cnt }개의 파일 확인</h3>
<ul>
<c:forEach var="i" begin="0" end="${cnt-1 }" step="1" varStatus="stat">
	<li>파일: ${stat.index + 1 }</li>
	<ul>
	<li>원본이름: ${originalFileNames[stat.index ] }</li>
	<li>파일시스템: ${fileSystemNames[stat.index ] }</li>
	</ul>
</c:forEach>
</ul>

<%-- GET방식 request시 url 에  한글이나 띄어쓰기 등이 들어가선 안되기 때문에 반드시 URLEncoder 로 처리 해야 한다
X ] http://localhost:8080/JSP18_FileUpload/FileDownload.jsp?fileSystemName=8퍼센트.ipynb
O ] http://localhost:8080/JSP18_FileUpload/FileDownload.jsp?fileSystemName=8%ED%8D%BC%EC%84%BC%ED%8A%B8.ipynb
java.net.URLEncoder  임포트!
--%>
<hr>
<h3>다운로드 링크1: get + JAVA</h3>
<% for(int i = 0; i < originalFileNames.length; i++){%>
	<%-- 화면에는 원본이름으로, 실제 링크는 업로드 저장된 이름으로 --%>
	<%
		String fname = URLEncoder.encode(fileSystemNames[i], "utf-8");
		String oname = URLEncoder.encode(originalFileNames[i], "utf-8");
	%>
	<a href="FileDownload.jsp?fileSystemName=<%=fname%>&originalFileName=<%=oname%>">
		<%=originalFileNames[i] %>
	</a><br>
<% } %>

<h3>다운로드 링크2: post + JAVA</h3>
<% for(int i = 0; i < originalFileNames.length; i++){%>
	<form action="FileDownload.jsp" name="frm<%=i %>" method="POST">
		<input type="hidden" name="fileSystemName" value="<%=fileSystemNames[i] %>">
		<input type="hidden" name="fileSystemName" value="<%=originalFileNames[i] %>">
		<p onclick="document.forms['frm<%=i%>'].submit()">
		<%= originalFileNames[i] %>
		</p>
	</form>
<% } %>

<h3>다운로드 링크3: post + JSTL</h3>
<c:forEach var="i" begin="0" end="${cnt - 1 }">
<form action="FileDownload.jsp" method="POST" name="ifrm${i }">
	<input type="hidden" name="fileSystemName" value="${fileSystemNames[i] }">
	<input type="hidden" name="fileSystemName" value="${originalFileNames[i] }">
	<p onclick="document.forms['frm${i}'].submit()">
	${originalFileNames[i] }
	</p>
</form>
</c:forEach>

<hr>

<%--
	웹 경로에 이미지 저장한 경우
 --%>
<h3>이미지 보기</h3>
<% for(int i = 0; i < originalFileNames.length; i++){ %>
<div style="width: 300px">
	<img style="width:100%; height:auto"
		src="upload/<%=fileSystemNames[i]%>"/>
</div>
<% } %>

</body>
</html>