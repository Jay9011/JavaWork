package com.lec.sts15_mybatis.board.command;

import java.util.Map;

import org.springframework.ui.Model;

import com.lec.sts15_mybatis.board.C;
import com.lec.sts15_mybatis.board.beans.IWriteDAO;

public class BDeleteCommand implements BCommand {

	@Override
	public void execute(Model model) {
		// model 을 Map 으로 만들어서 Map 방식으로 값을 가져오려고 한다.
		Map<String, Object> map = model.asMap();
		int uid = (Integer) map.get("uid");
		IWriteDAO dao = C.sqlSession.getMapper(IWriteDAO.class);
		model.addAttribute("result", dao.deleteByUid(uid));
	} // end execute()
} // end Command
