package com.lec.sts18_sercurity;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sample/*")
public class SampleController {
	
//	@RequestMapping(value = "/all", method = RequestMethod.GET) 의 축약형
	@GetMapping("/all")
	public void doAll() {	// 리턴타입이 없으면 url 과 같은 경로의 jsp 파일을 찾는다. ---> /all.jsp
		System.out.println("doAll() : access everybody");
	} // end doAll()
	
	@GetMapping("/member")
	public void doMember() {	// /member.jsp
		System.out.println("doMember() : access member only");
	} // end doMember()
	
	@GetMapping("/admin")
	public void doAdmin() {	// /admin.jsp
		System.out.println("doAdmin() : access admin only");
	} // end doAdmin()
} // end Controller
