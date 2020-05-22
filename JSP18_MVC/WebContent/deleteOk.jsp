<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%	// Controller 에서 데이터 가져오기
	int cnt = (Integer)request.getAttribute("result");
%>
<%-- 위 트랜잭션이 마무리 되면 페이지 보여주기 --%>
<% if(cnt == 0) {%>
	<script>
		alert("삭제 실패!!!");
		history.back();		// 브라우저가 기억하는 직전 페이지로 이동
	</script>
<%} else {%>
	<script>
		alert("삭제 성공.");
		location.href = "list.do";
	</script>
<%}%>