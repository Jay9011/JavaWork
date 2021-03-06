package com.command.write;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.WriteDAO;

public class WriteCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int cnt = 0;
		WriteDAO dao = new WriteDAO();

		// ajax response 에 필요한 값들
		StringBuffer message = new StringBuffer();
		String status = "FAIL";

		// 매개변수 받아오기
		String name = request.getParameter("name");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");

		// 유효성 체크
		if(name == null || name.trim().length() == 0) {
			message.append("[유효하지 않은 parameter : 작성자는 필수입니다.]");
		} else if(subject == null || subject.trim().length() == 0) {
			message.append("[유효하지 않은 parameter : 글 제목은 필수입니다.]");
		} else {
			try {
				cnt = dao.insert(subject, content, name);
				if(cnt == 0) {
					message.append("[트랜잭션 실패: 0 insert]");
				} else {
					status = "OK";
				}
			} catch (SQLException e) {
//				e.printStackTrace();
				message.append("[트랜잭션 에러:" + e.getMessage() + "]");
			} // end try
		} // end if

		request.setAttribute("result", cnt);
		request.setAttribute("status", status);
		request.setAttribute("message", message.toString());

	} // end execute()
} // end WriteCommand
