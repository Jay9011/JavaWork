package com.lec.sts15_mybatis.ticket;

public interface ITicketDAO {
	// 아래 두개의 동작이 하나의 트랜잭션으로 처리 되어야 한다.
	int insertCard(String userId, int buyAmount);
	int insertTicket(String userId, int ticketCount);
}
