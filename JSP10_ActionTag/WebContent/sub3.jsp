<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%! String name, age; %>
<%
request.setCharacterEncoding("UTF-8");
name = URLDecoder.decode(request.getParameter("name"), "utf-8");
age = request.getParameter("age");
%>
<p>이름: <%=name%></p>
<p>나이: <%=age%></p>