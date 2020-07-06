package com.lec.sts19_rest.board.command;

import org.springframework.ui.Model;

import com.lec.sts19_rest.board.C;
import com.lec.sts19_rest.board.beans.BWriteDTO;
import com.lec.sts19_rest.board.beans.IWriteDAO;
import com.lec.sts19_rest.board.beans.ListJSON;

public class BRUpdateCommand implements BRCommand {

	@Override
	public void execute(Model model) {
		ListJSON json = new ListJSON();
		IWriteDAO dao = C.sqlSession.getMapper(IWriteDAO.class);
		BWriteDTO dto = (BWriteDTO) model.getAttribute("dto");
		
		// ajax response 에 필요한 값들
		StringBuffer message = new StringBuffer();
		String status = "FAIL";
		
		int result = dao.update(dto.getUid(), dto);
		
		if(result > 0) {
			status = "OK";
			json.setCount(result);
			json.setStatus(status);
		} else {
			message.append("[데이터를 수정하는데 실패했습니다.]");
			json.setMessage(message.toString());
		} // end if-else
		
		model.addAttribute("json", json);
	} // end execute()
} // end Command
