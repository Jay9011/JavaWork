<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean id="cnt" class="com.lec.beans.CountBean" scope="request"/>
<h3>request2</h3>
<b>cnt 의 getCount 호출</b>

<jsp:getProperty property="count" name="cnt"/>

<a href="scope2_request1.jsp">request1으로...</a>