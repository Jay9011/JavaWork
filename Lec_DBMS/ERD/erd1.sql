
/* Drop Tables */

DROP TABLE REDISTER CASCADE CONSTRAINTS;
DROP TABLE Student CASCADE CONSTRAINTS;
DROP TABLE SUBJECT CASCADE CONSTRAINTS;
DROP TABLE Porfessor CASCADE CONSTRAINTS;




/* Create Tables */

CREATE TABLE Porfessor
(
	profno number NOT NULL,
	name varchar2(10) NOT NULL,
	deptno number,
	PRIMARY KEY (profno)
);


CREATE TABLE REDISTER
(
	studno number NOT NULL,
	SUBJNO number NOT NULL
);


CREATE TABLE Student
(
	studno number NOT NULL,
	name varchar2(10) NOT NULL,
	deptno number,
	profno number NOT NULL,
	PRIMARY KEY (studno)
);


CREATE TABLE SUBJECT
(
	SUBJNO number NOT NULL,
	NAME varchar2(10) NOT NULL,
	profno number NOT NULL,
	PRIMARY KEY (SUBJNO)
);



/* Create Foreign Keys */

ALTER TABLE Student
	ADD FOREIGN KEY (profno)
	REFERENCES Porfessor (profno)
;


ALTER TABLE SUBJECT
	ADD FOREIGN KEY (profno)
	REFERENCES Porfessor (profno)
;


ALTER TABLE REDISTER
	ADD FOREIGN KEY (studno)
	REFERENCES Student (studno)
;


ALTER TABLE REDISTER
	ADD FOREIGN KEY (SUBJNO)
	REFERENCES SUBJECT (SUBJNO)
;



