<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean id="cnt" class="com.lec.beans.CountBean" scope="page"/>

<b>cnt 의 getCount 호출</b>

<jsp:getProperty property="count" name="cnt"/>

<a href="scope1_page1">page1으로...</a>