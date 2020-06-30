<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- 
<h1>WriteDTO 타입으로 선언한 경우</h1>
uid : ${writeDTO.uid }<br>
작성자 : ${writeDTO.name }<br>
글 제목 : ${writeDTO.subject }<br>
내용 : ${writeDTO.content }<br>
--%>
<h1>ModelAttribute 로 ID를 바꾼 경우</h1>
uid : ${DTO.uid }<br>
작성자 : ${DTO.name }<br>
글 제목 : ${DTO.subject }<br>
내용 : ${DTO.content }<br>
조회수 : ${DTO.viewCnt }<br>
등록일 : ${DTO.regDate }<br>