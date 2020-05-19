package com.lec.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FormOk")
public class ServletForm extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ServletForm() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());

		// request.getParameterNames()
		System.out.println("getParameterNames() 사용");
		Enumeration<String> names = request.getParameterNames();
		while(names.hasMoreElements()) {
			String paramName = names.nextElement();
			String paramVlaue = request.getParameter(paramName);
			System.out.println(paramName + " : " + paramVlaue);
		}

		System.out.println("getParameterMap() 사용");
		Map<String, String[]> paramMap = request.getParameterMap();
		for (String key : paramMap.keySet()) {
			System.out.println(key + " : " + Arrays.toString(paramMap.get(key)));
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// post 방식. 한글 인코딩 처리 우선!!
		request.setCharacterEncoding("UTF-8");

		String data1 = request.getParameter("data1");
		String data2 = request.getParameter("data2");

		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");

		String[] hobbys = request.getParameterValues("hobby");
		String gender = request.getParameter("gender");
		String local = request.getParameter("local");
		String memo = request.getParameter("memo");

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		out.print("<html>"
				+ "<head>"
				+ "</head>"
				+ "<body>");
		out.printf("hidden : %s, %s <br />", data1, data2);
		out.print("이름 : " + name + "<br />"
				+ "아이디 : " + id + "<br />"
				+ "비밀번호 : " + pw + "<br />"
				+ "취미 : " + Arrays.toString(hobbys) + "<br />"
				+ "성별 : " + gender + "<br />"
				+ "지역 :" + local + "<br />"
				+ "메모 : " + memo + "<br />"
				+"</body>"
				+ "</html>");

		out.close();

		// request.getParameterNames()
		System.out.println("getParameterNames() 사용");
		Enumeration<String> names = request.getParameterNames();
		while(names.hasMoreElements()) {
			String paramName = names.nextElement();
			String paramVlaue = request.getParameter(paramName);
			System.out.println(paramName + " : " + paramVlaue);
		}

		System.out.println("getParameterMap() 사용");
		Map<String, String[]> paramMap = request.getParameterMap();
		for (String key : paramMap.keySet()) {
			System.out.println(key + " : " + Arrays.toString(paramMap.get(key)));
		}
	}

}
