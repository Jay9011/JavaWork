package com.lec.sts19_rest.board.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.lec.sts19_rest.board.C;
import com.lec.sts19_rest.board.beans.BWriteDTO;
import com.lec.sts19_rest.board.beans.IWriteDAO;

public class BRViewCommand {

	TransactionTemplate transactionTemplate;

	@Autowired
	public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
		this.transactionTemplate = transactionTemplate;
	} // setTransactionTemplate()
	
	public BWriteDTO viewAndIncCnt(final int uid) {
		BWriteDTO dto = new BWriteDTO();
		IWriteDAO dao = C.sqlSession.getMapper(IWriteDAO.class);
		
		transactionTemplate.execute(new TransactionCallbackWithoutResult() {
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {
				dao.incViewCnt(uid);
				BWriteDTO sub_dto = dao.selectByUid(uid);
				
				dto.setContent(sub_dto.getContent());
				dto.setName(sub_dto.getName());
				dto.setRegDate(sub_dto.getRegDate());
				dto.setSubject(sub_dto.getSubject());
				dto.setUid(sub_dto.getUid());
				dto.setViewCnt(sub_dto.getViewCnt());
			} // end doInTransactionWithoutResult()
		}); // end transactionTemplate.execute()
	
		return dto;

	} // viewAndIncCnt()
	
	
} // end Class
