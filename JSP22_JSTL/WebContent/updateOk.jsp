<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:choose>
	<c:when test="${result == 0}">
		<script>
			alert("수정 실패!!!");
			history.back();		// 브라우저가 기억하는 직전 페이지로 이동
		</script>
	</c:when>
	<c:otherwise>
		<script>
			alert("수정 성공.");
			location.href = 'view.do?uid=${param.uid}';
		</script>
	</c:otherwise>
</c:choose>