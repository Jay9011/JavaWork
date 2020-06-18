package com.command;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import common.lec.beans.CategoryDAO;
import common.lec.beans.CategoryDTO;
import common.lec.beans.CategoryJSON;

public class CateListCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		CategoryDAO dao = new CategoryDAO();
		CategoryDTO[] categoryDTOs = null;
		CategoryJSON result = new CategoryJSON();

		String parentString = request.getParameter("parent");
		int parent = 0;
		String depthString = request.getParameter("depth");
		int depth = 1;

		StringBuffer message = new StringBuffer();
		String status = "FAIL";
		int count = 0;

		if(depthString == null || depthString.trim().equals("")) {
		} else {
			try {
				depth = Integer.parseInt(depthString);
			} catch (NumberFormatException e1) {
				message.append("잘못 된 접근입니다.");
			} // end try-catch (depth가 숫자가 아닐 때)
		}

		if(depth == 1) {
			try {
				categoryDTOs = dao.selectCategoryRoot();
				status = "OK";
			} catch (SQLException e) {
				message.append("SQL 접근 에러 : " + e.getMessage());
			} // end try-catch (DAO 접근)
		} else {
			if(parentString == null || parentString.trim().equals("")) {
				message.append("잘못 된 접근입니다.");
			} else {
				try {
					parent = Integer.parseInt(parentString);
					categoryDTOs = dao.selectCategory(parent, depth);
					status = "OK";
				} catch (NumberFormatException e) {
					// parent 가 숫자가 아니면
					message.append("잘못 된 접근입니다.");
				} catch (SQLException e) {
					// SQL 오류
					message.append("SQL 접근 에러 : " + e.getMessage());
				} // end try-catch
			} // end if-else (parent 가 없으면)
		} // end if-else (depth가 1인지 아닌지 확인)


		if(categoryDTOs != null) {
			count = categoryDTOs.length;
		}

		if(count == 0) {
			status = "FAIL";
			message.append("불러올 값이 없습니다.");
		}

		result.setCount(count);
		result.setStatus(status);
		if(message != null) result.setMessage(message.toString());
		if(categoryDTOs != null) result.setList(Arrays.asList(categoryDTOs));

		ObjectMapper mapper = new ObjectMapper();

		try {
			String jsonString =
					mapper.writerWithDefaultPrettyPrinter()
					.writeValueAsString(result);
			response.setContentType("application/json; charset=utf-8");
			response.getWriter().write(jsonString);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	} // end execute()
} // end Class
