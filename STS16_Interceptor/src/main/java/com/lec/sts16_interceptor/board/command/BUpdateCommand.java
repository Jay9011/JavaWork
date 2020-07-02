package com.lec.sts16_interceptor.board.command;

import java.util.List;
import java.util.Map;

import org.springframework.ui.Model;

import com.lec.sts16_interceptor.board.beans.BWriteDAO;
import com.lec.sts16_interceptor.board.beans.BWriteDTO;

public class BUpdateCommand implements BCommand {

	@Override
	public void execute(Model model) {
		// model 을 Map 으로 만들어서 Map 방식으로 값을 가져오려고 한다.
		Map<String, Object> map = model.asMap();
		BWriteDTO dto = (BWriteDTO) map.get("dto");
		BWriteDAO dao = new BWriteDAO();
		model.addAttribute("result", dao.update(dto));
		
	} // end execute()
} // end Command
