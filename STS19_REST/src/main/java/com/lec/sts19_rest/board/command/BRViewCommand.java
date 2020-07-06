package com.lec.sts19_rest.board.command;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.ui.Model;

import com.lec.sts19_rest.board.C;
import com.lec.sts19_rest.board.beans.BWriteDTO;
import com.lec.sts19_rest.board.beans.IWriteDAO;
import com.lec.sts19_rest.board.beans.ListJSON;

public class BRViewCommand implements BRCommand{

	TransactionTemplate transactionTemplate;

	@Autowired
	public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
		this.transactionTemplate = transactionTemplate;
	} // setTransactionTemplate()

	@Override
	public void execute(Model model) {
		ListJSON json = new ListJSON();
		IWriteDAO dao = C.sqlSession.getMapper(IWriteDAO.class);
		BWriteDTO dto = null;
		int uid = (int) model.getAttribute("uid");
		
		// ajax response 에 필요한 값들
		StringBuffer message = new StringBuffer();
		String status = "FAIL";
		
		transactionTemplate.execute(new TransactionCallbackWithoutResult() {
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {
				dao.incViewCnt(uid);
				BWriteDTO sub_dto = dao.selectByUid(uid);
				
				model.addAttribute("dto", sub_dto);
			} // end doInTransactionWithoutResult()
		}); // end transactionTemplate.execute()
		
		dto = (BWriteDTO) model.getAttribute("dto");
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
		
		model.addAttribute("json", json);
	} // end execute()
} // end Class
