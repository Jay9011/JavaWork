<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%	// Controller 에서 결과 받아오기
	int cnt = (Integer)request.getAttribute("result");
	int uid = Integer.parseInt(request.getParameter("uid"));
%>
<%-- 위 트랜젝션이 마무리 되면 페이지 보여주기 --%>
<% if(cnt == 0) {%>
	<script>
		alert("수정 실패!!!");
		history.back();		// 브라우저가 기억하는 직전 페이지로 이동
	</script>
<%} else {%>
	<script>
		alert("수정 성공.");
		location.href = "view.do?uid=<%=uid%>";
	</script>
<%}%>