package com.command.write;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.WriteDAO;
import com.lec.beans.WriteDTO;

public class ViewCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		WriteDAO dao = new WriteDAO();
		WriteDTO[] arr = null;

		// ajax response 에 필요한 값들
		StringBuffer message = new StringBuffer();
		String status = "FAIL";

		String param = request.getParameter("uid");

		// 유효성 검사
		if(param == null) {
			message.append("읽어올 글이 없습니다.");
		} else {
			try {
				int uid = Integer.parseInt(param);
				arr = dao.readByUid(uid);

				if(arr == null) {
					message.append("[해당 데이터가 없습니다.]");
				} else {
					status = "OK";
				}
			} catch (SQLException e) {
//				e.printStackTrace();
				message.append("[트랜잭션 에러:" + e.getMessage() + "]");
			} catch (Exception e) {
				message.append("[예외발생:" + e.getMessage() + "]");
			} // end try
		}

		request.setAttribute("list", arr);
		request.setAttribute("status", status);
		request.setAttribute("message", message.toString());
	}

}
