
/* Drop Tables */

DROP TABLE test_card CASCADE CONSTRAINTS;
DROP TABLE test_ticket CASCADE CONSTRAINTS;




/* Create Tables */

CREATE TABLE test_card
(
	user_id varchar2(20) NOT NULL,
	buy_amount number DEFAULT 1
);


CREATE TABLE test_ticket
(
	user_id varchar2(20) NOT NULL,
	ticket_count number NOT NULL,
	CONSTRAINT ticket_buy_limit
	CHECK (ticket_count BETWEEN 1 AND 5)
);

SELECT * FROM TEST_CARD ;
SELECT * FROM TEST_TICKET ;

-- ticket 2장을 카드로 결제하는 경우
INSERT INTO TEST_CARD VALUES ('aaa', 2); -- OK
INSERT INTO TEST_TICKET VALUES ('aaa', 2); -- OK

-- ticket 5장을 카드로 결제하는 경우
INSERT INTO TEST_CARD VALUES ('aaa', 5); -- OK
INSERT INTO TEST_TICKET VALUES ('aaa', 5); -- OK

-- ticket 6장을 카드로 결제하는 경우
INSERT INTO TEST_CARD VALUES ('aaa', 6); -- OK
INSERT INTO TEST_TICKET VALUES ('aaa', 6); -- ORA-02290: check constraint (SCOTT0316.TICKET_BUY_LIMIT) violated