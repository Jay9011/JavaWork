package com.lec.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Cycle")
public class ServletCycle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	// 서블릿 생성자, 첫 request 발생시 최초 단 한 번 생성된다.
    public ServletCycle() {
        super();
        System.out.println("서블릿 생성");
    }
    
    // 서블릿 객체 생성 이후(직후)
    @Override
    public void init() throws ServletException {
    	System.out.println("init 호출");
    }

    // 서블릿 객체 소멸시
    @Override
    public void destroy() {
    	System.out.println("destroy 호출");
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet 호출");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost 호출");
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("service() 호출");
	}

}
