
/* Drop Triggers */

DROP TRIGGER TRI_Member_m_uid;
DROP TRIGGER TRI_m_user_m_uid;
DROP TRIGGER TRI_Reserve_r_uid;
DROP TRIGGER TRI_TODOList_td_uid;
DROP TRIGGER TRI_user_m_uid;



/* Drop Tables */

DROP TABLE Reserve CASCADE CONSTRAINTS;
DROP TABLE payment CASCADE CONSTRAINTS;
DROP TABLE TODORow CASCADE CONSTRAINTS;
DROP TABLE TODOList CASCADE CONSTRAINTS;
DROP TABLE m_user CASCADE CONSTRAINTS;



/* Drop Sequences */

DROP SEQUENCE SEQ_Member_m_uid;
DROP SEQUENCE SEQ_m_user_m_uid;
DROP SEQUENCE SEQ_Reserve_r_uid;
DROP SEQUENCE SEQ_TODOList_td_uid;
DROP SEQUENCE SEQ_user_m_uid;




/* Create Sequences */

CREATE SEQUENCE SEQ_Member_m_uid INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_m_user_m_uid INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_Reserve_r_uid INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_TODOList_td_uid INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_user_m_uid INCREMENT BY 1 START WITH 1;



/* Create Tables */

CREATE TABLE m_user
(
	m_uid number NOT NULL,
	m_id varchar2(20) NOT NULL UNIQUE,
	m_pw varchar2(100) NOT NULL,
	m_name varchar2(20) NOT NULL,
	m_jumin number NOT NULL,
	m_email varchar2(200) NOT NULL,
	m_phoneNum number NOT NULL,
	m_gender varchar2(6),
	m_job number,
	m_addressP varchar2(25),
	m_addressA varchar2(150),
	m_addressB varchar2(150),
	m_SMSOk number,
	m_EmailOk number,
	m_profile blob,
	m_grade number NOT NULL DEFAULT 1,
	PRIMARY KEY (m_uid)
);


CREATE TABLE payment
(
	tid varchar2(60) NOT NULL,
	partner_order_id varchar2(300),
	item_name varchar2(300),
	total_amount number,
	tax_free_amount number,
	pay_date date,
	m_uid number NOT NULL,
	PRIMARY KEY (tid)
);


CREATE TABLE Reserve
(
	r_uid number NOT NULL,
	t_uid varchar2(15) NOT NULL,
	r_startTime date,
	r_endTime date,
	m_uid number NOT NULL,
	tid varchar2(60) NOT NULL,
	PRIMARY KEY (r_uid)
);


CREATE TABLE TODOList
(
	td_uid number NOT NULL UNIQUE,
	td_date date NOT NULL DEFAULT SYSDATE,
	m_uid number NOT NULL,
	PRIMARY KEY (td_uid)
);


CREATE TABLE TODORow
(
	tr_content clob NOT NULL,
	tr_checked number NOT NULL DEFAULT 0,
	td_uid number NOT NULL UNIQUE
);



/* Create Foreign Keys */

ALTER TABLE payment
	ADD FOREIGN KEY (m_uid)
	REFERENCES m_user (m_uid)
;


ALTER TABLE Reserve
	ADD FOREIGN KEY (m_uid)
	REFERENCES m_user (m_uid)
;


ALTER TABLE TODOList
	ADD FOREIGN KEY (m_uid)
	REFERENCES m_user (m_uid)
;


ALTER TABLE Reserve
	ADD FOREIGN KEY (tid)
	REFERENCES payment (tid)
;


ALTER TABLE TODORow
	ADD FOREIGN KEY (td_uid)
	REFERENCES TODOList (td_uid)
;



/* Create Triggers */

CREATE OR REPLACE TRIGGER TRI_Member_m_uid BEFORE INSERT ON Member
FOR EACH ROW
BEGIN
	SELECT SEQ_Member_m_uid.nextval
	INTO :new.m_uid
	FROM dual;
END;

/

CREATE OR REPLACE TRIGGER TRI_m_user_m_uid BEFORE INSERT ON m_user
FOR EACH ROW
BEGIN
	SELECT SEQ_m_user_m_uid.nextval
	INTO :new.m_uid
	FROM dual;
END;

/

CREATE OR REPLACE TRIGGER TRI_Reserve_r_uid BEFORE INSERT ON Reserve
FOR EACH ROW
BEGIN
	SELECT SEQ_Reserve_r_uid.nextval
	INTO :new.r_uid
	FROM dual;
END;

/

CREATE OR REPLACE TRIGGER TRI_TODOList_td_uid BEFORE INSERT ON TODOList
FOR EACH ROW
BEGIN
	SELECT SEQ_TODOList_td_uid.nextval
	INTO :new.td_uid
	FROM dual;
END;

/

CREATE OR REPLACE TRIGGER TRI_user_m_uid BEFORE INSERT ON user
FOR EACH ROW
BEGIN
	SELECT SEQ_user_m_uid.nextval
	INTO :new.m_uid
	FROM dual;
END;

/




