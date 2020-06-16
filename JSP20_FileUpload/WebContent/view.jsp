<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%-- JSTL 버전으로 바뀌니, import 번잡함도 사라진다. JAVA 변수 선언도 사라진다 --%>
<c:choose>
	<c:when test="${empty viewInfo || fn:length(viewInfo) == 0 }">
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
<title>읽기 ${viewInfo[0].subject}</title>	<%-- title 에 글제목 넣기 --%>
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
<h2>읽기 ${viewInfo[0].subject}</h2>
<br>
UID : ${viewInfo[0].uid}<br>
작성자 : ${viewInfo[0].name}<br>
제목 : ${viewInfo[0].subject}<br>
등록일 : ${viewInfo[0].regDate}<br>
조회수 : ${viewInfo[0].viewCnt}<br>
<hr>
내용 : <br>
<div>
${viewInfo[0].content}
</div>
<hr>
<%-- 첨부파일 및 다운로드 링크 --%>
<c:if test="${fn:length(file) > 0 }">
	<h4>첨부파일</h4>
	<ul>
		<c:forEach var="element" items="${file }">
			<li><a href="download.do?uid=${element.uid }">${element.source }</a></li>
		</c:forEach>

		<!-- 이미지인 경우 보여주기 -->
		<c:forEach var="element" items="${file }">
			<c:if test="${element.image == true }">
				<div style="width:300px">
					<img alt="" src="upload/${element.file }" style="width:100%; height:auto;">
				</div>
			</c:if>
		</c:forEach>
	</ul>
</c:if>

<br>
<button onclick="location.href = 'update.do?uid=${viewInfo[0].uid}'">수정하기</button>
<button onclick="location.href = 'list.do'">목록보기</button>
<button onclick="chkDelete(${viewInfo[0].uid})">삭제하기</button>
<button onclick="location.href = 'write.do'">신규등록</button>
</body>
</html>
	</c:otherwise>
</c:choose>