
/* Drop Triggers */

DROP TRIGGER TRI_free_board_fb_uid;
DROP TRIGGER TRI_free_board_uid;



/* Drop Tables */

DROP TABLE free_board CASCADE CONSTRAINTS;



/* Drop Sequences */

DROP SEQUENCE SEQ_free_board_fb_uid;
DROP SEQUENCE SEQ_free_board_uid;




/* Create Sequences */

CREATE SEQUENCE SEQ_free_board_fb_uid INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_free_board_uid INCREMENT BY 1 START WITH 1;



/* Create Tables */

CREATE TABLE free_board
(
	fb_uid number NOT NULL,
	fb_title varchar2(200) NOT NULL,
	fb_content clob,
	fb_name varchar2(20) NOT NULL,
	fb_date date DEFAULT SYSDATE,
	fb_viewcnt number DEFAULT 0,
	PRIMARY KEY (fb_uid)
);



/* Create Triggers */

CREATE OR REPLACE TRIGGER TRI_free_board_fb_uid BEFORE INSERT ON free_board
FOR EACH ROW
BEGIN
	SELECT SEQ_free_board_fb_uid.nextval
	INTO :new.fb_uid
	FROM dual;
END;

/

CREATE OR REPLACE TRIGGER TRI_free_board_uid BEFORE INSERT ON free_board
FOR EACH ROW
BEGIN
	SELECT SEQ_free_board_uid.nextval
	INTO :new.uid
	FROM dual;
END;

/


SELECT * FROM FREE_BOARD;

