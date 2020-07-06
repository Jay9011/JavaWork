package com.lec.sts19_rest.board.command;

import java.util.List;

import org.springframework.ui.Model;

import com.lec.sts19_rest.board.C;
import com.lec.sts19_rest.board.beans.BWriteDTO;
import com.lec.sts19_rest.board.beans.IWriteDAO;
import com.lec.sts19_rest.board.beans.ListJSON;

public class BRListCommand implements BRCommand {

	@Override
	public void execute(Model model) {
		ListJSON json = new ListJSON();
		IWriteDAO dao = C.sqlSession.getMapper(IWriteDAO.class);

		int page = (int) model.getAttribute("page");
		int pageRows = (int) model.getAttribute("pageRows");
		
		// ajax response 에 필요한 값들
		StringBuffer message = new StringBuffer();
		String status = "FAIL";
		
		// 페이징 관련 세팅값들
		int writePages = 10;// 한 [페이징]에 몇 개의 '페이지'를 표시할 것인가?
		int totalCnt = 0;	// 글은 총 몇개인가?
		int totalPage = 0;	// 최대 '페이지' 분량 계산
		
		totalCnt = dao.countAll();
		
		// 최대 페이지 분량 구하기
		totalPage = (int)Math.ceil(totalCnt / (double)pageRows);
		
		// 몇 번째 row 부터?
		int fromRow = (page - 1) * pageRows + 1;	// ORACLE 은 1부터 ROWNUM 시작
		List<BWriteDTO> list = dao.selectFromRow(fromRow, fromRow + pageRows);

		if(list.size() == 0) {
			message.append("[리스트 할 데이터가 없습니다]");
		} else {
			json.setData(list);
			status = "OK";
		} // end if-else
		
		json.setMessage(message.toString());
		json.setStatus(status);
		json.setCount(list.size());
		json.setPage(page);
		json.setPagerows(pageRows);
		json.setTotalcnt(totalCnt);
		json.setTotalpage(totalPage);
		json.setWritepages(writePages);
		
		model.addAttribute("json", json);
	} // end execute()
} // end Command
