package com.lec.sts15_mybatis.board.command;

import java.util.Map;

import org.springframework.ui.Model;

import com.lec.sts15_mybatis.board.C;
import com.lec.sts15_mybatis.board.beans.BWriteDTO;
import com.lec.sts15_mybatis.board.beans.IWriteDAO;

public class BWriteCommand implements BCommand {

	@Override
	public void execute(Model model) {
//		BWriteDAO dao = new BWriteDAO();
//		int result = dao.insert(dto);
//		model.addAttribute("result", result);
		
		// Model 안에 있는 값(attribute) 꺼내기
		Map<String, Object> map = model.asMap();
		BWriteDTO dto = (BWriteDTO) map.get("dto");

		// MyBatis 사용
		IWriteDAO dao = C.sqlSession.getMapper(IWriteDAO.class);
		model.addAttribute("result", dao.insert(dto));
		System.out.println("생성된 uid 는 " + dto.getUid());
//		model.addAttribute("result", dao.insert(dto.getSubject(), dto.getContent(), dto.getName()));
	} // end execute()
} // end Command