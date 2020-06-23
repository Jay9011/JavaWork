<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String servlet_request_uri = (String) request.getAttribute("javax.servlet.forward.request_uri");
	String conPath = request.getContextPath();
	
//	System.out.println(servlet_request_uri);
//	System.out.println(conPath);

	String servlet_reqpath = servlet_request_uri.substring(conPath.length());
	
	String uri = request.getRequestURI();
	String reqpath = uri.substring(conPath.length());
	String url = request.getRequestURL().toString();
	
	// jsp 파일명
	String jspFile = uri.substring(uri.lastIndexOf("/") + 1, uri.length());
	String jspName = uri.substring(uri.lastIndexOf("/") + 1, uri.length() - 4);
	
	request.setAttribute("jspName", jspName);
%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title><%= jspName %></title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/CSS/sts_common.css">
</head>
<body>
<div class="sts">
<h2>servlet</h2>
<b>request URI : </b><span><%= servlet_request_uri %></span><br>
<b>context path : </b><span><%= conPath %></span><br>
<b>request path : </b><span><%= servlet_reqpath %></span><br>
<b>VIEW file : </b><span><%= jspFile %></span><br>
<hr>
<h2>VIEW(JSP)</h2>
<b>url : </b><span><%= url %></span><br>
<b>VIEW Path : </b><span><%= reqpath %></span><br>
<b>uri : </b><span><%= uri %></span><br>
</div>
</body>
</html>