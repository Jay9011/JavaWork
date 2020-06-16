package com.command.write;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.WriteDAO;
import com.lec.beans.WriteDTO;

public class SelectCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		WriteDAO dao = new WriteDAO();
		WriteDTO[] arr = null;

		// ajax response 에 필요한 값들
		StringBuffer message = new StringBuffer();
		String status = "FAIL";


		int uid = Integer.parseInt(request.getParameter("uid"));

		try {
			arr = dao.selectByUid(uid);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		request.setAttribute("selected", arr);
		request.setAttribute("status", status);
		request.setAttribute("message", message.toString());
	}

}
