package com.lec.sts15_mybatis.board.command;

import java.util.Arrays;
import java.util.Map;

import org.springframework.ui.Model;

import com.lec.sts15_mybatis.board.C;
import com.lec.sts15_mybatis.board.beans.IWriteDAO;

public class BSelectCommand implements BCommand {

	@Override
	public void execute(Model model) {
		System.out.println("getAttribute(\"uid\") : " + (Integer) model.getAttribute("uid"));
		// model 을 Map 으로 만들어서 Map 방식으로 값을 가져오려고 한다.
		Map<String, Object> map = model.asMap();
		int uid = (Integer) map.get("uid");
		
		// 기존 배열을 List 로 변환할 수 있지만
		// Arrays.asList(new String[]{"aaa", "bbb"})
		
		// Arrays.asList(T... a) 매서드는 가변매개변수로 받아올 수 있기 때문에, 
		// 단 하나의 자료를 리스트로 변환시킬 수 있기도 하다.
		// Arrays.asList("aaa", "bbb")
		
		IWriteDAO dao = C.sqlSession.getMapper(IWriteDAO.class);
		model.addAttribute("list", Arrays.asList(dao.selectByUid(uid)));
	} // end execute()
} // end Command
