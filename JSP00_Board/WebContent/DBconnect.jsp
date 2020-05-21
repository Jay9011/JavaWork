<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%!
Connection conn = null;
Statement stmt = null;
PreparedStatement pstmt = null;
ResultSet rs = null;
int cnt = 0;

final String DRIVER = "oracle.jdbc.driver.OracleDriver";
final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
final String USERID = "SCOTT0316";
final String USERPW = "TIGER0316";
%>