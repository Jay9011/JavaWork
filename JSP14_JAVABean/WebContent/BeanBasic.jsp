<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean id="person1" class="com.lec.beans.Person" scope="page"/>
<%--
	Person person1 = new com.lec.beans.Person();	// 기본 생성자 호출
	request.setAttribute("person1", person1);		// 좀 더 정확히는 이 코드도 수행
 --%>

<%-- 기본 생성자 생성 후 useBean 안에서 setProperty 사용 --%>
 <jsp:useBean id="person2" class="com.lec.beans.Person" scope="page">
 	<jsp:setProperty property="name" name="person2" value="명기범"/>
 	<jsp:setProperty property="age" name="person2" value="26"/>
 	<jsp:setProperty property="id" name="person2" value="99887"/>
 	<jsp:setProperty property="gender" name="person2" value="남"/>
 </jsp:useBean>

 <%--
 	form 에서 넘어온 값을 bean 객체가 바로 받을 수 있다.
 	bean 의 필드명(getter/setter 명) 과 form 의 name 이 일치해야 한다.
  --%>
<jsp:useBean id="person3" class="com.lec.beans.Person" scope="page"/>
<jsp:setProperty property="name" name="person3"/>
<jsp:setProperty property="age" name="person3"/>
<jsp:setProperty property="id" name="person3"/>
<jsp:setProperty property="gender" name="person3"/>
<%-- person3.getName(request.getParameter("name")) --%>
<%-- person3.getAge(request.getParameter("age")) --%>
<%-- person3.getId(request.getParameter("id")) --%>
<%-- person3.getGender(request.getParameter("gender")) --%>


<jsp:useBean id="person4" class="com.lec.beans.Person" scope="page"/>
<jsp:setProperty property="*" name="person4"/>
<%-- 넘어온 모든 Parameter 를 일괄 저장할 수 있다. --%>



<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>자바빈</title>
</head>
<body>
	<jsp:setProperty property="name" name="person1" value="고길동"/>
	<jsp:setProperty property="age" name="person1" value="24"/>
	<jsp:setProperty property="id" name="person1" value="1515"/>
	<jsp:setProperty property="gender" name="person1" value="남"/>
	<%--
		person1.setName("고길동");
		person1.setAge(24);
		person1.setId(1515);
		person1.setGender("남");
	 --%>

	<h3>Person1</h3>
	이름: <jsp:getProperty property="name" name="person1"/><br>
	나이: <jsp:getProperty property="age" name="person1"/><br>
	아이디: <jsp:getProperty property="id" name="person1"/><br>
	성별: <jsp:getProperty property="gender" name="person1"/><br>
	<%--
		person1.getName();
		person1.getAge();
		person1.getId();
		person1.getGender();
	 --%>

	<h3>Person2</h3>
	이름: <jsp:getProperty property="name" name="person2"/><br>
	나이: <jsp:getProperty property="age" name="person2"/><br>
	아이디: <jsp:getProperty property="id" name="person2"/><br>
	성별: <jsp:getProperty property="gender" name="person2"/><br>

	<h3>Person3</h3>
	이름: <jsp:getProperty property="name" name="person3"/><br>
	나이: <jsp:getProperty property="age" name="person3"/><br>
	아이디: <jsp:getProperty property="id" name="person3"/><br>
	성별: <jsp:getProperty property="gender" name="person3"/><br>

	<h3>Person4</h3>
	이름: <jsp:getProperty property="name" name="person4"/><br>
	나이: <jsp:getProperty property="age" name="person4"/><br>
	아이디: <jsp:getProperty property="id" name="person4"/><br>
	성별: <jsp:getProperty property="gender" name="person4"/><br>
</body>
</html>