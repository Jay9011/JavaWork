package com.lec.sts13_jdbc.board.command;

import java.util.List;
import java.util.Map;

import org.springframework.ui.Model;

import com.lec.sts13_jdbc.board.beans.BWriteDAO;
import com.lec.sts13_jdbc.board.beans.BWriteDTO;

public class BViewCommand implements BCommand {

	@Override
	public void execute(Model model) {
		// Model 안에 있는 값(attribute) 꺼내기
		BWriteDAO dao = new BWriteDAO();
		BWriteDTO dto = (BWriteDTO) model.getAttribute("dto");
		List<BWriteDTO> list = dao.readByUid(dto.getUid());
		model.addAttribute("list", list);
	} // end execute()
} // end Command
