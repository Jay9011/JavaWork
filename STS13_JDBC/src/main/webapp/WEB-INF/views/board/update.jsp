<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="old.*" %>

<%	// Controller 로부터 결과 받아옴
	WriteDTO[] arr = (WriteDTO[])request.getAttribute("selected");
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
<title>수정 <%=subject%></title>
</head>
<script>
function chkSubmit(){
	frm = document.forms['frm'];
	var subject = frm['subject'].value.trim();

	if(subject == ""){
		alert("제목은 반드시 작성해야 합니다.");
		frm['subject'].focus();
		return false;
	}
	return true;
}
</script>
<body>
<h2>수정</h2>
<form action="updateOk.do" name="frm" method="post" onsubmit="return chkSubmit()">
<input type="hidden" name="uid" value="<%=uid%>"/>
작성자 : <%=name%><br>
제목 : <input type="text" name="subject" value="<%=subject%>" /><br>
등록일 : <%=regDate%><br>
조회수 : <%=viewCnt%><br>
<hr>
내용 :
<div>
<textarea name="content" cols="30" rows="10"><%=content%></textarea><br>
</div>
<hr><br>
<input type="submit" value="수정" />
<button onclick="history.back()">이전으로</button>
<button onclick="location.href='list.do'">목록보기</button>
</form>
</body>
</html>