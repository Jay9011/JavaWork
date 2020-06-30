package com.lec.sts11_param;

import java.text.DateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.lec.beans.WriteDTO;

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
	
	/**
	 * parameter 추출
	 * handler 메소드에서도 서블릿에서 보앗던 HttpServletRequest, HttpServletResponse 매개변수 가능.!!!
	 */
	@RequestMapping(value = "/member/delete", method = RequestMethod.GET)	// -> /member/delete?id=34
//	public String delMember(Model model, HttpServletRequest request) {
	public String delMember(HttpServletRequest request, Model model) {
		String id = request.getParameter("id");
		model.addAttribute("mbId", id);
		
		return "member/delete";
	} // end delMember
	
	@RequestMapping(value = "/member/regist")
	public String registMember() {
		return "member/regist";
	} // end registMember()

	/**
	 * POST 만 받는 Mapping
	 * @return
	 */
	@RequestMapping(value = "/member/regOk", method = RequestMethod.POST)
	public String regOkMember() {
		System.out.println("/member/regOk : POST");
		return "member/regOk";
	} // end regOkMember

	/**
	 * GET 만 받는 Mapping
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/member/regOk", method = RequestMethod.GET)
	public String regOkMember(Model model) {
		System.out.println("/member/regOk : GET");
		return "member/regOk";
	} // end regOkMember
	
	/**
	 * GET/POST 둘다 받는 handler
	 * @return
	 */
	@RequestMapping(value = "/member/regOk2", 
			method = {RequestMethod.GET, RequestMethod.POST})
	public String regOkMember2() {
		return "member/regOk";
	} // end regOkMember2()

	/**
	 * handler 에 
	 * request parameter 의 name 값과 '같은 이름의 매개변수' 가 있으면 
	 * 바로 그 매개변수가 같은 name 의 request parameter 값을 받아온다.
	 * @param id
	 * @param name
	 * @param model
	 * @return
	 */
	@RequestMapping("/member/find")
	public String findMember(int[] id, String[] name, Model model) {	// 순서 무관!
//		model.addAttribute("id", id * 2);
		model.addAttribute("id", Arrays.toString(id));
		model.addAttribute("name", Arrays.toString(name));
		
		return "member/find";
	} // end findMember()
	
	/**
	 * @RequestParam 사용
	 */
	@RequestMapping("/member/find2")
	public String findMember(Model model,
			@RequestParam("id") String userid,	// name "id" parameter 값을 받아온다.
			@Nullable@RequestParam("name") String username) {	// @Nullable 을 쓰면 null 을 허용한다.
		
		model.addAttribute("id", userid);
		model.addAttribute("name", username);
		
		return "member/find";
	} // end findMember()
	
	/**
	 * 커맨드 객체 (Command Object) 사용
	 * @return "board/write"
	 */
	@RequestMapping("/board/write")
	public String writeBoard() {
		return "board/write";
	} // end writeBoard()
	
	/**
	 * 기존 방식으로 구현하기
	 * 매 Parameter 들을 매개변수화? 해야 한다. 힘들다...
	 */
	@RequestMapping(value = "/board/writeOk", method = RequestMethod.POST)
	public String writeOkBoard(
				Model model,
				@RequestParam("name") String name,
				@RequestParam("subject") String subject,
				@RequestParam("content") String content
			) {
		WriteDTO dto = new WriteDTO();
		dto.setName(name);
		dto.setSubject(subject);
		dto.setContent(content);
		
		model.addAttribute("dto", dto);
		
		return "/board/writeOk";
	} // end writeOkBoard()
	
	/**
	 * 커맨드 객체 사용
	 * 커맨드 객체의 '타입명'이 model 의 'attribute' 가 된다.
	 * @param dto
	 * @return
	 */
//	@RequestMapping(value = "/board/writeOk2", method = RequestMethod.POST)
//	public String writeOkBoard(WriteDTO dto) {
//		return "/board/writeOk2";
//	} // end writeOkBoard()

	/**
	 * @ModelAttribute 로
	 * 커맨드 객체의 model 의 'attribute' 이름을 바꿔줄 수 있다.
	 * @param dto
	 * @return
	 */
	@RequestMapping(value = "/board/writeOk2", method = RequestMethod.POST)
	public String writeOkBoard(
			@ModelAttribute("DTO") WriteDTO dto) {
		System.out.println(dto);
		return "/board/writeOk2";
	} // end writeOkBoard()
	
	@RequestMapping("/board/writePath/{name}/{subject}/{content}")
	public String writePathBoard(Model model,
			@PathVariable String name,
			@PathVariable String subject,
			@PathVariable String content
			) {
		model.addAttribute("name", name);
		model.addAttribute("subject", subject);
		model.addAttribute("content", content);
		return "board/writepath";
	} // end writePathBoard()
	
	/**
	 * redirect:
	 * 핸들러 메소드의 뷰 리턴값에 redirect: 를 사용하면
	 * 해당 URL로 redirect 된다.
	 * RedirectAttributes 를 사용하면 redirect: 를 하는 페이지에 
	 * Parameter 로 RedirectAttributes 를 넘겨줄 수 있다.
	 * @param age
	 * @param redirectAttr
	 * @return
	 */
	@RequestMapping("/member/ageCheck")
	public String chkAge(int age, RedirectAttributes redirectAttr) {
		redirectAttr.addAttribute("age", age);
		if(age < 19) {
			return "redirect:/member/underAge";
		} else {
			return "redirect:/member/adult";
		} // end if-else
	} // end chkAge()
	/**
	 * redirect: 로 불려질 때 RedirectAttributes 에 값을 담았다면
	 * parameter 에서 @RequestParam("name") 으로 원하는 값을 불러올 수 있다.
	 * @param age
	 * @param model
	 * @return
	 */
	@RequestMapping("/member/underAge")
	public String pageUnderAge(@RequestParam("age") int age, Model model) {
		model.addAttribute("age", age);
		return "member/ageUnder";
	} // end pageUnderAge()
	@RequestMapping("/member/adult")
	public String pageAdult(@RequestParam("age") int age, Model model) {
		model.addAttribute("age", age);
		return "member/ageAdult";
	} // end pageAdult()
	
} // end HomeConotroller
