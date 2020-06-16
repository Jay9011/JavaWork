<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- cos 라이브러리 --%>
<%@ page import="com.oreilly.servlet.MultipartRequest" %>
<%@ page import="com.oreilly.servlet.multipart.FileRenamePolicy" %>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>

<%-- parameter 값들, file 값들 추출 --%>
<%@ page import="java.util.Enumeration" %>

<%-- File 객체 --%>
<%@ page import="java.io.File" %>

<%-- 이미지 파일 다루기 --%>
<%@ page import="java.awt.image.BufferedImage" %>
<%@ page import="javax.imageio.ImageIO" %>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
</head>
<body>

<form action="FileCheck.jsp" method="post" name="fileCheck">
<%
	// MultipartRequest 객체 생성 준비
	// String saveDirectory = "C:\\tomcat\\upload";

	/***
	 *	파일 저장 경로
	 *	서버에서(서블릿) 어디에 어느 폴더에서 서블릿으로 변환되는지 알아내기
	 */
	ServletContext context = this.getServletContext();
	// 서블릿상의 upload 폴더의 물리적인 경로 얻어오기
	String saveDirectory = context.getRealPath("upload");


	System.out.println("업로드 경로 : " + saveDirectory);

	int maxPostSize = 5 * 1024 * 1024;	// POST 받기, 최대 크기 5Mbyte
	String encoding = "utf-8";
	FileRenamePolicy policy = new DefaultFileRenamePolicy();	// 업로딩 파일 이름 중복에 대한 정책

	MultipartRequest multi = null;	// com.oreilly.servlet.MultipartRequest 임포트

	try {	// jsp 파일에서 예외를 반드시 catch 할 필요는 없지만...

		// MultipartRequest 생성단계에서 이미 파일은 저장됨.
		multi = new MultipartRequest(
			request,	// JSP 내부객체 request
			saveDirectory,	// 업로드 된 파일 저장 경로
			maxPostSize,	// 최대 파일 크기 (post 크기)
			encoding,
			policy	// 중복 이름 파일 rename 객체
		);

		Enumeration names = null;
		// 1. Parameter name 들 추출
		names = multi.getParameterNames();	// 일반적인 form parameter name 들 추출
		while(names.hasMoreElements()){
			String name = (String)names.nextElement();	// name
			String value = multi.getParameter(name);	// value
			out.print(name + " : " + value + "<br>");
		}
		out.print("<hr>");

		// 2. File 들 추출
		names = multi.getFileNames();	// type="file" 요소 name 들 추출
		while(names.hasMoreElements()){
			String name = (String)names.nextElement();
			out.print("input name : " + name + "<br>");

			// 위 name 의 업로드 파일명을 가져올 수 있다.
			String originalFileName = multi.getOriginalFileName(name);
			out.println("원본파일 이름 : " + originalFileName + "<br>");
			out.print("<input type='hidden' name='originalFileName' value='" + originalFileName + "'>");

			// 서버 시스템에 '저장된 파일명'을 가져온다.
			String fileSystemName = multi.getFilesystemName(name);
			out.println("파일시스템 이름 : " + fileSystemName + "<br>");
			out.print("<input type='hidden' name='fileSystemName' value='" + fileSystemName + "'>");

			// 업로딩된 파일의 타입 : MIME 타입(ex: image/png ...)
			String fileType = multi.getContentType(name);
			out.print("파일 MIME 타입 : " + fileType + "<br>");

			// 문자열 '파일이름'이 name 에 들어온 상태
			// 문자열 파일이름을 통해 실제 파일 정보를 -> File 객체로 가져오기
			File file = multi.getFile(name);
			if(file != null){
				long fileSize = file.length();	// 파일 크기 (byte)
				out.print("파일크기 : " + fileSize + "bytes<br>");

				// 이미지 파일 다루기
				BufferedImage bi = ImageIO.read(file);
				if(bi != null){	// ★★이미지 파일 판별
					int width = bi.getWidth();
					int height = bi.getHeight();
					out.print("이미지파일 WxH : " + width + " x " + height + "<br>");
				} else {
					out.print("이미지가 아닙니다.<br>");
				}
			}
			out.print("<hr>");

		} // end while

	} catch (Exception e) {
		e.printStackTrace();
		out.print("파일 처리 예외 발생<br>");
	}
%>
<input type="submit" value="업로드 파일 확인"><br>
</form>

</body>
</html>