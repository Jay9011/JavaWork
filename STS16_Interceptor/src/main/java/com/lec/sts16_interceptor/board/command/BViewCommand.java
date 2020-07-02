package com.lec.sts16_interceptor.board.command;

import java.util.Arrays;
import java.util.Map;

import org.springframework.ui.Model;

import com.lec.sts16_interceptor.board.beans.BWriteDAO;
import com.lec.sts16_interceptor.board.beans.BWriteDTO;

public class BViewCommand implements BCommand {

	@Override
	public void execute(Model model) {
		System.out.println("getAttribute(\"uid\") : " + (Integer) model.getAttribute("uid"));
		// model 을 Map 으로 만들어서 Map 방식으로 값을 가져오려고 한다.
		Map<String, Object> map = model.asMap();
		BWriteDAO dao = new BWriteDAO();
		BWriteDTO result = dao.readByUid((Integer) map.get("uid"));
		model.addAttribute("list", Arrays.asList(result));
		
		// 기존 배열을 List 로 변환할 수 있지만
		// Arrays.asList(new String[]{"aaa", "bbb"})
		
		// Arrays.asList(T... a) 매서드는 가변매개변수로 받아올 수 있기 때문에, 
		// 단 하나의 자료를 리스트로 변환시킬 수 있기도 하다.
		// Arrays.asList("aaa", "bbb")
		
	} // end execute()
} // end Command
