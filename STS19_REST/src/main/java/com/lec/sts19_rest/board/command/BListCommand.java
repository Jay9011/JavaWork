package com.lec.sts19_rest.board.command;

import org.springframework.ui.Model;

import com.lec.sts19_rest.board.C;
import com.lec.sts19_rest.board.beans.IWriteDAO;

public class BListCommand implements BCommand {

	@Override
	public void execute(Model model) {
//		BWriteDAO dao = new BWriteDAO();
//		List<BWriteDTO> list = dao.select();
//		model.addAttribute("list", list);

		/**
		 * MyBatis 사용
		 * DAO 매서드만 정의해준 Interface 를
		 * Mapper 에서 자동으로 쿼리문을 생성해준다. 
		 */
		IWriteDAO dao = C.sqlSession.getMapper(IWriteDAO.class);
		model.addAttribute("list", dao.select());
	} // end execute()
} // end Command
