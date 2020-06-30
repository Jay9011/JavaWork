package com.lec.sts13_jdbc.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lec.sts13_jdbc.board.C;
import com.lec.sts13_jdbc.board.beans.BWriteDTO;
import com.lec.sts13_jdbc.board.command.BCommand;
import com.lec.sts13_jdbc.board.command.BListCommand;
import com.lec.sts13_jdbc.board.command.BViewCommand;
import com.lec.sts13_jdbc.board.command.BWriteCommand;

@Controller
@RequestMapping("/board")
public class BoardController {
	private BCommand command;
	private JdbcTemplate template;

	public BoardController() {
		super();
		System.out.println("BoardController() 생성");
	} // end BoardController()

	@Autowired
	public void setTemplate(JdbcTemplate template) {
		System.out.println("setTemplate() 호출");
		this.template = template;
		C.template = template;
	} // end setTemplate()
	
	@RequestMapping("/list.do")
	public String list(Model model) {
		command = new BListCommand();
		command.execute(model);
		return "board/list";
	} // end list()
	
	@RequestMapping("/write.do")
	public String write(Model model) {
		return "board/write";
	} // end write()
	
	@RequestMapping(value = "writeOk.do", method = RequestMethod.POST)
	public String writeOk(BWriteDTO dto, Model model) {
		model.addAttribute("dto", dto);
		new BWriteCommand().execute(model);
		return "board/writeOk";
	} // end writeOk()
	
	@RequestMapping("/view.do")
	public String view(BWriteDTO dto, Model model) {
		model.addAttribute("dto", dto);
		new BViewCommand().execute(model);
		return "board/view";
	} // end view()
	
} // end Controller
