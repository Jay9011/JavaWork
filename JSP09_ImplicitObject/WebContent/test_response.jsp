<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%! int age;%>
<%
String str = request.getParameter("age");
age = Integer.parseInt(str);

if(age < 18){
response.sendRedirect("underage.jsp?age=" + age);
} else {
response.sendRedirect("adult.jsp?age=" + age);
}
%>