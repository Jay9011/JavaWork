package com.lec.sts19_rest.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lec.sts19_rest.board.C;
import com.lec.sts19_rest.board.beans.BWriteDTO;
import com.lec.sts19_rest.board.beans.IWriteDAO;
import com.lec.sts19_rest.board.beans.ListJSON;
import com.lec.sts19_rest.board.command.BRCommand;
import com.lec.sts19_rest.board.command.BRDeleteCommand;
import com.lec.sts19_rest.board.command.BRListCommand;
import com.lec.sts19_rest.board.command.BRUpdateCommand;
import com.lec.sts19_rest.board.command.BRViewCommand;
import com.lec.sts19_rest.board.command.BRWriteCommand;

@RestController
@RequestMapping("/board")
public class BoardRestController {
	// 사용 할 Command 목록
	@Autowired
	BRViewCommand viewCommand;
	BRCommand command;
	
	@RequestMapping("/list/{page}/{pageRows}")
	public ListJSON restList(Model model, @PathVariable("page") int page, @PathVariable("pageRows") int pageRows){
		model.addAttribute("page", page);
		model.addAttribute("pageRows", pageRows);
		
		new BRListCommand().execute(model);
		
		ListJSON json = (ListJSON) model.getAttribute("json");
		
		return json;
	} // end listJSON()
	
	@RequestMapping("/view/{uid}")
	public ListJSON restView(Model model, @PathVariable("uid")int uid) {
		model.addAttribute("uid", uid);
		try {
			viewCommand.execute(model);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ListJSON json = (ListJSON) model.getAttribute("json");
		
		return json;
	} // end restView()
	
	@RequestMapping(value = "/writeOk", method = RequestMethod.POST)
	public ListJSON writeOk(Model model, BWriteDTO dto) {
		model.addAttribute("dto", dto);
		
		new BRWriteCommand().execute(model);
		
		ListJSON json = (ListJSON) model.getAttribute("json");
		
		return json;
	} // end writeOk()
	
	@RequestMapping(value = "/deleteOk", method = RequestMethod.POST)
	public ListJSON deleteOk(Model model, int[] uid) {
		model.addAttribute("uid", uid);
		
		new BRDeleteCommand().execute(model);
		
		ListJSON json = (ListJSON) model.getAttribute("json");
		
		return json;
	} // end deleteOk()
	
	@RequestMapping(value = "/updateOk", method = RequestMethod.POST)
	public ListJSON updateOk(Model model, BWriteDTO dto) {
		model.addAttribute("dto", dto);
		
		new BRUpdateCommand().execute(model);
		
		ListJSON json = (ListJSON) model.getAttribute("json");
		
		return json;
	} // end updateOk()
	
}// end RestController
