package com.lec.sts10_request.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/member")	// ---> /member 로 시작하는 request 만 처리
public class MemberController {

	@RequestMapping(value = "/save")	// ---> /member + /save => /member/save
	public String saveMember() {
		
		return "member/saver";
	} // end saveMember()
	
	
	@RequestMapping(value = "/load")	// ---> /member/load
	public String loadMember() {
		
		return "member/load";
	} // end loadMember()
	
	/**
	 * 	HomeController 와 중복된 Mapping 이 존재하면 어떻게 되는 걸까?
	 * 	@return View(String)
	 *  @exception Ambiguous mapping found.
	 */
//	@RequestMapping(value = "/search")	// ---> /member/search
//	public String search() {
//		
//		return "member/search";
//	} // end search()
	
	
} // end Controller
