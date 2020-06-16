package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.command.write.AjaxListCommand;
import com.command.write.AjaxResultCommand;
import com.command.write.Command;
import com.command.write.DeleteCommand;
import com.command.write.ListCommand;
import com.command.write.SelectCommand;
import com.command.write.UpdateCommand;
import com.command.write.ViewCommand;
import com.command.write.WriteCommand;

@WebServlet("*.ajax")
public class AjaxController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AjaxController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ajaxAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ajaxAction(request, response);
	}

	protected void ajaxAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ajaxAction() 호출");

		request.setCharacterEncoding("UTF-8");

		// 컨트롤러는 다음 두개를 선택해야 한다.
		String viewPage = null;		// 어떠한 뷰?		--> 페이지
		Command command = null;		// 어떠한 커맨드?	--> 로직 수행

		// URL로 부터 URI, ContextPath, Command 분리
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());

		// 테스트 출력
		System.out.println("uri: " + uri);
		System.out.println("conPath: " + conPath);
		System.out.println("com: " + com);

		// 컨트롤러는 커맨드에 따라, 로직을 수행하고
		// 결과를 내보낼 view 를 결정한다.
		switch(com) {
		case "/list.ajax":   // A 글목록(페이징)
			new ListCommand().execute(request, response);
			new AjaxListCommand().execute(request, response);
			break;

		case "/view.ajax":  // B 글 읽기
			new ViewCommand().execute(request, response);
			new AjaxListCommand().execute(request, response);
			break;

		case "/writeOk.ajax": // C 글작성
			new WriteCommand().execute(request, response);
			new AjaxResultCommand().execute(request, response);
			break;

		case "/updateOk.ajax": // D 글 수정
			new UpdateCommand().execute(request, response);
			new AjaxResultCommand().execute(request, response);
			break;

		case "/deleteOk.ajax":  // F 글 삭제
			new DeleteCommand().execute(request, response);
			new AjaxResultCommand().execute(request, response);
			break;
		} // end switch

	}  // ajaxAction

} // end Controller
