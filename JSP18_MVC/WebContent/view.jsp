<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="com.lec.beans.*" %>

<%	// Controller 로부터 결과 데이터 받음.
	WriteDTO[] arr = (WriteDTO[])request.getAttribute("viewInfo");
%>
<%	if(arr == null || arr.length == 0){	%>
		<script>
			alert("해당 정보가 삭제되었거나 존재하지 않습니다.");
			history.back();
		</script>
<%	} // end if	%>
<%
	int uid = arr[0].getUid();
	String name = arr[0].getName();
	String subject = arr[0].getSubject();
	String content = arr[0].getContent();
	String regDate = arr[0].getRegDate();
	int viewCnt = arr[0].getViewCnt();
%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>읽기 <%= subject %></title>	<%-- title 에 글제목 넣기 --%>
</head>
<script>
function chkDelete(uid){
	// 삭제 여부, 다시 확인 하고 진행하기
	var r = confirm("정말로 삭제하시겠습니까?");
	if(r){
		location.href = 'deleteOk.do?uid=' + uid;
	} else {

	}
}
</script>
<body>
<h2>읽기 <%= subject %></h2>
<br>
UID : <%=uid%><br>
작성자 : <%=name%><br>
제목 : <%=subject%><br>
등록일 : <%=regDate%><br>
조회수 : <%=viewCnt%><br>
<hr>
내용 : <br>
<div>
<%=content%>
</div>
<hr><br>
<button onclick="location.href = 'update.do?uid=<%=uid%>'">수정하기</button>
<button onclick="location.href = 'list.do'">목록보기</button>
<button onclick="chkDelete(<%=uid%>)">삭제하기</button>
<button onclick="location.href = 'write.do'">신규등록</button>
</body>
</html>