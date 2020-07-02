package com.lec.sts13_jdbc.board.command;

import java.util.Map;

import org.springframework.ui.Model;

import com.lec.sts13_jdbc.board.beans.BWriteDAO;

public class BDeleteCommand implements BCommand {

	@Override
	public void execute(Model model) {
		// model 을 Map 으로 만들어서 Map 방식으로 값을 가져오려고 한다.
		Map<String, Object> map = model.asMap();
		BWriteDAO dao = new BWriteDAO();
		model.addAttribute("result", dao.deleteByUid((Integer) map.get("uid")));
	} // end execute()
} // end Command
