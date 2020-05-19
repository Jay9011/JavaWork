package com.let.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Sev")
public class ServletDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletDemo() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet() 호출");	// 테스트
		int sum = 0;
		for(int cnt = 1; cnt <= 100; cnt++) {
			sum += cnt;
		}
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.print("<html>");
		out.print("<head>");
		out.print("<title>백까지 합</title>");
		out.print("</head>");
		out.print("<body>");
		out.printf("100까지의 합 결과 : %d", sum);
		out.print("</body>");
		out.print("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost() 호출");
		doGet(request, response);
	}

}
