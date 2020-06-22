<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<img src="/sts09_mvc/resources/img/zelda_01.jpg"/><br>
<img src="<%= request.getContextPath() %>/resources/img/zelda_01.jpg"/><br>
<img src="${pageContext.request.contextPath }/resources/img/zelda_01.jpg"/><br>
<img src="/sts09_mvc/myRes/img/zelda_03.jpg"/><br>
</body>
</html>
