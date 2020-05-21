package com.lec.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ContextEx")
public class ContextEx extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ContextEx() {
        super();
    }

    @Override
    public void init() throws ServletException {
    	System.out.println("Init() 실행!");
    }

    @Override
    public void destroy() {
    	System.out.println("destroy() 종료준비!");
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("App START~~");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
