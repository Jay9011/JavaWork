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
<form action="updateOk.do" name="frm" method="post"
	onsubmit="return chkSubmit()" enctype="Multipart/form-data">
	<%-- 수정 단계에서 파일 추가 가능 Multipart request --%>
<input type="hidden" name="uid" value="${selected[0].uid}"/>
작성자 : ${selected[0].name}<br>
제목 : <input type="text" name="subject" value="${selected[0].subject}" /><br>
등록일 : ${selected[0].regDate}<br>
조회수 : ${selected[0].viewCnt}<br>
<hr>
내용 :
<div>
<textarea name="content" cols="30" rows="10">${selected[0].content}</textarea><br>
</div><br>
	<%-- 첨부파일 목록 (삭제대상) --%>
	<c:if test="${fn:length(file) > 0 }">
	<div style="background-color: #DDD; padding:2px 10px; margin-bottom:5px; border:1px solid black;">
		<h4>첨부파일 - 삭제할 것에 체크하세요</h4>
		<div id="delFiles"></div>
		<c:forEach var="element" items="${file }">
			<div>
				<button type="button" onclick="deleteFiles(${element.uid}); $(this).parent().remove();">삭제</button>${element.source }
			</div>
		</c:forEach>
	</div>
	</c:if>
	<script>
	function deleteFiles(fileUid){
		// 삭제할 file 의 bf_uid 값(들)을 delfile 에 담아 submit 한다.
		$("#delFiles").append("<input type='hidden' name='delfile' value='" + fileUid + "'>");
	}
	</script>

	<%-- 첨부파일 추가 --%>
	<div style="background-color: #DDD; padding:2px 10px; margin-bottom:5px; border:1px solid black;">
		<h4>첨부파일</h4>
		<button type="button" id="btnAdd">추가</button>
		<div id="files"></div>
	</div>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script>
	var i = 0;
	$("#btnAdd").click(function(){
		$('#files').append('<div><input type="file" name="upfile' + i + '" /><button type="button" onclick="$(this).parent().remove()">삭제</button></div>');
		i++;
	});
	</script>
<hr>
<input type="submit" value="수정" />
<button type="button" onclick="history.back()">이전으로</button>
<button type="button" onclick="location.href='list.do'">목록보기</button>
</form>
</body>
</html>
	</c:otherwise>
</c:choose>