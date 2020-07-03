package com.lec.sts19_rest.board.command;

import java.util.Map;

import org.springframework.ui.Model;

import com.lec.sts19_rest.board.C;
import com.lec.sts19_rest.board.beans.BWriteDTO;
import com.lec.sts19_rest.board.beans.IWriteDAO;

public class BUpdateCommand implements BCommand {

	@Override
	public void execute(Model model) {
		// model 을 Map 으로 만들어서 Map 방식으로 값을 가져오려고 한다.
		Map<String, Object> map = model.asMap();
		BWriteDTO dto = (BWriteDTO) map.get("dto");

		IWriteDAO dao = C.sqlSession.getMapper(IWriteDAO.class);
//		model.addAttribute("result", dao.update(dto));
		model.addAttribute("result", dao.update(dto.getUid(), dto));
	} // end execute()
} // end Command
