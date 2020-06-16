package com.command.write;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.FileDAO;
import com.lec.beans.WriteDAO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.FileRenamePolicy;

public class UpdateCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		WriteDAO dao = new WriteDAO();
		FileDAO fileDAO = new FileDAO();	// 첨부파일

		/**
		 * 	1. 업로드 할 파일(들) 처리
		 */
		ServletContext context = request.getServletContext();
		String saveDirectory = context.getRealPath("upload");

		int maxPostSize = 5 * 1024 * 1024;
		String encoding = "utf-8";
		FileRenamePolicy policy = new DefaultFileRenamePolicy();
		MultipartRequest multi = null;
		try {
			multi = new MultipartRequest(
						request,
						saveDirectory,
						maxPostSize,
						encoding,
						policy
					);
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		List<String> originalFileNames = new ArrayList<String>();
		List<String> fileSystemNames = new ArrayList<String>();

		Enumeration names = multi.getFileNames();	// type="file" 요소의 name들 추출
		while(names.hasMoreElements()) {
			String name = (String)names.nextElement();
			String originalFileName = multi.getOriginalFileName(name);
			String fileSystemName = multi.getFilesystemName(name);
			System.out.println("첨부파일 : " + originalFileName + "->" + fileSystemName);

			if(originalFileName != null && fileSystemName != null) {
				originalFileNames.add(originalFileName);
				fileSystemNames.add(fileSystemName);
			}
		} // end while


		/**
		 * 	2. 삭제될 첨부파일(들) 처리
		 */
		String[] delfiles = multi.getParameterValues("delfile");
		if(delfiles != null && delfiles.length > 0) {	// 삭제 대상의 파일이 있다면
			int[] delFileUids = new int[delfiles.length];

			for(int i = 0; i < delFileUids.length; i++) {
				delFileUids[i] = Integer.parseInt(delfiles[i]);
			}

			try {
				fileDAO.deleteByUid(delFileUids, request);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} // end if


		/**
		 * 	3. 글 수정
		 */
		int uid = Integer.parseInt(multi.getParameter("uid"));
		String subject = multi.getParameter("subject");
		String content = multi.getParameter("content");

		int cnt = 0;

		if(subject != null && subject.trim().length() > 0) {
			try {
				cnt = dao.update(uid, subject, content);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		/**
		 * 	추가된 첨부파일(들) 처리
		 */
		fileDAO = new FileDAO();
		try {
			fileDAO.insert(uid, originalFileNames, fileSystemNames);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		request.setAttribute("uid", uid);	// Multipart 로 받은 뒤 updateOk.jsp 로 넘겨야 함.
		request.setAttribute("result", cnt);
	}

}
