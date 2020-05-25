<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>JSTL Core 2</title>
</head>
<body>
<h2>set, remove, out</h2>
<c:set var="name" value="윤종섭"/>
이름 : <c:out value="Yun"/><br>
이름 : <c:out value="${name}"/><br> <%-- JSTL 변수는 EL 에서 사용 가능 --%>

<c:remove var="name"/>
이름 : <c:out value="${name}"/><br> <%-- 변수 제거 가능 --%>
<hr />

<%
	int age = 10;
%>
나이 : ${age }<br> <%-- Java → EL 사용 불가 --%>
<c:set var="age" value="<%=age %>"/> <%-- 하지만, Java → JSTL → EL 로 변환 가능 --%>
나이 : ${age }<br>
<hr />

<h2>catch</h2>
<c:catch var="error">
	<!-- 이 안에서 예외 발생하면 예외객체를 error 변수에 담는다 -->
	<%= 2 / 0 %>
</c:catch>
<c:out value="${error }"/><br />
<br />
<c:catch var="ex">
	name parameter 값 = <%=request.getParameter("name") %><br>
	<%if(request.getParameter("name").equals("test")){ %>
		${param.name } 은 test입니다.
	<%} %>
</c:catch>
<c:if test="${ex != null }"> <%-- catch(예외발생) 되면 --%>
	<c:out value="${ex }"/><br />
</c:if>

</body>
</html>