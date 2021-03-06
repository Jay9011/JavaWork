package com.lec.sts10_request;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	} // end home
	
	@RequestMapping(value = "/common")	// /common 으로 요청이 오면
	public String cccmmm() {			// cccmmm() Handler 가 실행된다.
		return "comn";	// ---> /WEB-INF/views/comn.jsp		를 리턴해서 response 하게 된다.
	} // end cccmmm()
	
	@RequestMapping(value = "/member/search")	// /member/search 로 요청이 오면
	public String searchMember() {				// searchMember() Handler 가 실행된다.
		return "member/search";		// ---> /WEB-INF/views/member/search.jsp	를 VIEW 로 한다.
	} // end searchMember()
	
	@RequestMapping(value = "/member/infoView")
	public String infoMember(Model model) {
		model.addAttribute("mbAge", 12);
		model.addAttribute("mbName", "윤종섭");
		
		return "member/info";
	} // end infoMember
	
	@RequestMapping(value = "/member/find")
	public ModelAndView findMember() {
		ModelAndView mv = new ModelAndView();
		
		// 데이터도 담고
		mv.addObject("mbName", "타임머신");
		mv.addObject("mbDate", "2002/04/23");
		
		// 뷰도 지정한다.
		mv.setViewName("member/find");
		
		return mv;
	} // end findMember()
	
	/**
	 * 	확장자 패턴 사용 가능
	 */
	@RequestMapping(value = "/member/*.do")
	public String doMember() {
		
		return "member/doMember";
	}
	
} // end HomeController
