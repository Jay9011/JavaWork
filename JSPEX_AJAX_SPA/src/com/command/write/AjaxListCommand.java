package com.command.write;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lec.beans.AjaxWriteList;
import com.lec.beans.AjaxWriteResult;
import com.lec.beans.WriteDTO;

public class AjaxListCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		WriteDTO[] dtoArr = (WriteDTO[]) request.getAttribute("list");

		AjaxWriteList result = new AjaxWriteList();

		result.setStatus((String) request.getAttribute("status"));
		result.setMessage((String) request.getAttribute("message"));

		if(dtoArr != null) {
			result.setCount(dtoArr.length);
			result.setList(Arrays.asList(dtoArr));
		}

		try {
			result.setPage((Integer) request.getAttribute("page"));
			result.setTotalPage((Integer) request.getAttribute("totalPage"));
			result.setWritePages((Integer) request.getAttribute("writePage"));
			result.setPageRows((Integer) request.getAttribute("pageRow"));
			result.setTotalCnt((Integer) request.getAttribute("totalCnt"));
		} catch (Exception e) {
			// view.ajax 에선 페이징 관련 변수값이 없다.
		}

		ObjectMapper mapper = new ObjectMapper();	// JsonMapper

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
} // end Command
