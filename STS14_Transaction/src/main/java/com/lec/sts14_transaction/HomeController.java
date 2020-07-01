package com.lec.sts14_transaction;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	} // end home()
	
	/**
	 * DAO 설정
	 */
	
//	private TicketDAO1 dao;	// 트랜잭션 미적용
//	private TicketDAO2 dao;	// 트랜잭션 적용
	private TicketDAO3 dao;	// TransactionTemplate 사용
//	@Autowired
//	public void setDao1(TicketDAO1 dao) { 
//		this.dao = dao; 
//	}
//	@Autowired
//	public void setDao1(TicketDAO2 dao) { 
//		this.dao = dao; 
//	}
	@Autowired
	public void setDao1(TicketDAO3 dao) { 
		this.dao = dao; 
	}
	
	
	@RequestMapping("/buy_ticket")
	public String buy_ticket() {
		return "buy_ticket";	// 티켓 구매 양식
	} // end buy_ticket()
	
	/**
	 * 티켓 구매 처리
	 * @param dto
	 * @param model
	 * @return page
	 */
	@RequestMapping("/buy_ticket_card")
	public String buy_ticket_card(TicketDTO dto, Model model) {
		System.out.println("/buy_ticket_card");
		System.out.println("user id : " + dto.getUserId());
		System.out.println("ticket count : " + dto.getTicketCount());
		
		String page = "buy_ticket_done";
		
		try {
			dao.buyTicket(dto);	// 트랜잭션이 발생되어야 함.
			model.addAttribute("ticketInfo", dto);
		} catch (Exception e) {
			e.printStackTrace();
			page = "buy_ticket_fail";
		} // end try-catch
		
		return page;
	} // end buy_ticket_card()

	

} // end Controller
