package com.lec.sts19_rest.board.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lec.sts19_rest.board.C;
import com.lec.sts19_rest.board.beans.BWriteDTO;
import com.lec.sts19_rest.board.beans.IWriteDAO;
import com.lec.sts19_rest.board.beans.ListJSON;
import com.lec.sts19_rest.board.command.BRViewCommand;

@RestController
@RequestMapping("/board")
public class BoardRestController {
	@Autowired
	BRViewCommand viewCommand;
	
	@RequestMapping("/list/{page}/{pageRows}")
	public ListJSON restList(@PathVariable("page") int page, @PathVariable("pageRows") int pageRows){
		ListJSON json = new ListJSON();
		
		// ajax response 에 필요한 값들
		StringBuffer message = new StringBuffer();
		String status = "FAIL";
		
		// 페이징 관련 세팅값들
		int writePages = 10;// 한 [페이징]에 몇 개의 '페이지'를 표시할 것인가?
		int totalCnt = 0;	// 글은 총 몇개인가?
		int totalPage = 0;	// 최대 '페이지' 분량 계산
		
		IWriteDAO dao = C.sqlSession.getMapper(IWriteDAO.class);
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
		json.setCount(list.size());
		json.setPage(page);
		json.setPagerows(pageRows);
		json.setStatus(status);
		json.setTotalcnt(totalCnt);
		json.setTotalpage(totalPage);
		json.setWritepages(writePages);
		
		return json;
	} // end listJSON()
	
	@RequestMapping("/view/{uid}")
	public ListJSON restView(@PathVariable("uid")int uid) {
		ListJSON json = new ListJSON();
		
		// ajax response 에 필요한 값들
		StringBuffer message = new StringBuffer();
		String status = "FAIL";
		
		IWriteDAO dao = C.sqlSession.getMapper(IWriteDAO.class);
		BWriteDTO dto = null;
//		dao.incViewCnt(uid);
//		BWriteDTO dto = dao.selectByUid(uid);
		try {
			dto = viewCommand.viewAndIncCnt(uid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<BWriteDTO> list = new ArrayList<BWriteDTO>();
		
		if(dto == null) {
			message.append("[데이터가 없습니다]");
		} else {
			list.add(dto);
			json.setData(list);
			status = "OK";
		} // end if-else
		
		json.setMessage(message.toString());
		json.setCount(list.size());
		json.setStatus(status);
		
		return json;
	} // end restView()
	
	@RequestMapping(value = "/writeOk", method = RequestMethod.POST)
	public ListJSON writeOk(BWriteDTO dto) {
		ListJSON json = new ListJSON();
		
		// ajax response 에 필요한 값들
		StringBuffer message = new StringBuffer();
		String status = "FAIL";
		
		IWriteDAO dao = C.sqlSession.getMapper(IWriteDAO.class);
		
		int result = dao.insert(dto);
		if( result > 0) {
			status = "OK";
			json.setCount(result);
			json.setStatus(status);
		} else {
			message.append("[데이터를 추가하는데 실패했습니다.]");
			json.setMessage(message.toString());
		} // end if-else
		
		return json;
	} // end writeOk()
	
	@RequestMapping(value = "/deleteOk", method = RequestMethod.POST)
	public ListJSON deleteOk(int[] uid) {
		ListJSON json = new ListJSON();
		
		// ajax response 에 필요한 값들
		StringBuffer message = new StringBuffer();
		String status = "FAIL";
		
		IWriteDAO dao = C.sqlSession.getMapper(IWriteDAO.class);
		int result = 0;
				
		for (int i : uid) {
			result += dao.deleteByUid(i);
		} // end for
		
		if(result > 0) {
			status = "OK";
			json.setCount(result);
			json.setStatus(status);
		} else {
			message.append("[데이터를 삭제하는데 실패했습니다.]");
			json.setMessage(message.toString());
		} // end if-else
		
		return json;
	} // end deleteOk()
	
	@RequestMapping(value = "/updateOk", method = RequestMethod.POST)
	public ListJSON updateOk(BWriteDTO dto) {
		ListJSON json = new ListJSON();
		
		// ajax response 에 필요한 값들
		StringBuffer message = new StringBuffer();
		String status = "FAIL";
		
		IWriteDAO dao = C.sqlSession.getMapper(IWriteDAO.class);
		int result = dao.update(dto.getUid(), dto);
		
		if(result > 0) {
			status = "OK";
			json.setCount(result);
			json.setStatus(status);
		} else {
			message.append("[데이터를 수정하는데 실패했습니다.]");
			json.setMessage(message.toString());
		} // end if-else
		
		return json;
	} // end updateOk()
	
}// end RestController
