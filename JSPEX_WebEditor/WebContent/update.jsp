<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:choose>
	<c:when test="${empty selected || fn:length(selected) == 0}">
		<script>
			alert("해당 정보가 삭제되었거나 존재하지 않습니다.");
			history.back();
		</script>
	</c:when>
	<c:otherwise>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>수정 ${selected[0].subject}</title>
<script src="ckeditor/ckeditor.js"></script>
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
<input type="hidden" name="uid" value="${selected[0].uid}"/>
작성자 : ${selected[0].name}<br>
제목 : <input type="text" name="subject" value="${selected[0].subject}" /><br>
등록일 : ${selected[0].regDate}<br>
조회수 : ${selected[0].viewCnt}<br>
<hr>
내용 :
<div>
<textarea id="editor1" name="content" cols="30" rows="10">${selected[0].content}</textarea><br>
</div>
<script>
	CKEDITOR.replace('editor1',{
		allowedContent: true	// HTML 태그 자동 삭제 방지 설정
		, width: '640px'
		, height: '400px'
		, filebrowserUploadUrl: '${pageContext.request.contextPath}/fileUpload.do'
	});
</script>
<hr><br>
<input type="submit" value="수정" />
<button type="button" onclick="history.back()">이전으로</button>
<button type="button" onclick="location.href='list.do'">목록보기</button>
</form>
</body>
</html>
	</c:otherwise>
</c:choose>