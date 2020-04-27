
/* Drop Tables */

DROP TABLE phonebook CASCADE CONSTRAINTS;




/* Create Tables */

CREATE TABLE phonebook
(
	pb_uid number NOT NULL,
	pb_name varchar2(40) NOT NULL,
	pb_phonenum varchar2(40),
	pb_memo clob,
	pb_regdate date DEFAULT SYSDATE,
	PRIMARY KEY (pb_uid)
);

-- 시퀀스 객체 생성
DROP SEQUENCE phonebook_seq;
CREATE SEQUENCE phonebook_seq;

SELECT * FROM PHONEBOOK ;

SELECT count(*) cnt FROM TEST_MEMBER ;
SELECT max(mb_no) "max" FROM TEST_MEMBER ;
SELECT min(mb_no) "min" FROM TEST_MEMBER ;
SELECT MAX(pb_uid) AS max FROM PHONEBOOK ;
SELECT * FROM seq WHERE SEQUENCE_NAME = 'PHONEBOOK_SEQ';
SELECT * FROM USER_SEQUENCES WHERE SEQUENCE_NAME = 'PHONEBOOK_SEQ';
