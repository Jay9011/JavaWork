package com.lec.sts16_interceptor.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		/**
		 * 로그인 여부 처리
		 */
		// session 객체 가져오기
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		
		/**
		 * 컨트롤러 실행 전
		 * (Handler 실행 전)
		 */
		System.out.println("[preHandle] id : " + id);
		
		if(id == null) {
			// 직전 요청했던 url 을 세션에 기록한다.
			String urlPrior =
					request.getRequestURL().toString() + "?" + request.getQueryString();
			request.getSession().setAttribute("url_prior_login", urlPrior);
			
			// 만약 로그인이 되어있지 않다면, 로그인 페이지로 redirect 시킨다
			response.sendRedirect(request.getContextPath() + "/user/login");
			return false;	// ★★ 더 이상 컨트롤러 핸들러를 진행하지 않도록 false 리턴. (Request 진행을 멈춘다)
		}
		
		return true;	// ★ true 면, 컨트롤러 핸들러를 진행. (계속해서 Request 를 진행한다)
	} // end preHandle()

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		/**
		 * 컨트롤러 실행 후, 뷰 직전
		 * (Handler 실행 직후)
		 */
		System.out.println("[postHandle]");
		super.postHandle(request, response, handler, modelAndView);
	} // end postHandle()

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		/**
		 * 뷰 Response 후
		 */
		System.out.println("[afterCompletion]");
		super.afterCompletion(request, response, handler, ex);
	} // end afterCompletion()

	@Override
	public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		/**
		 * 비동기 방식으로 불렀을 때
		 */
		System.out.println("[afterConcurrentHandlingStarted]");
		super.afterConcurrentHandlingStarted(request, response, handler);
	} // end afterConcurrentHandlingStarted()

} // end Class
