SELECT TNAME FROM TAB;
-- T_DEPT2.DCODE 참조 예정
SELECT * FROM T_DEPT2 ; -- DCODE : 0001, 1000...1011

-- #9001
-- 제약조건명을 명시하지 않는 방법
DROP TABLE T_EMP3 CASCADE CONSTRAINT;
CREATE TABLE T_EMP3 (
	NO NUMBER(4) PRIMARY KEY,
	NAME VARCHAR2(10) NOT NULL,
	JUMIN VARCHAR2(13) NOT NULL UNIQUE,
	AREA NUMBER(1) CHECK(AREA < 5),
	DEPTNO VARCHAR2(6) REFERENCES T_DEPT2(DCODE)
);

-- 별도의 항목으로 제약조건 정의 가능
DROP TABLE T_EMP4 CASCADE CONSTRAINT;
CREATE TABLE T_EMP4 (
	NO NUMBER(4),
	NAME VARCHAR2(10) NOT NULL,
	JUMIN VARCHAR2(13) NOT NULL,
	AREA NUMBER(1),
	DEPTNO VARCHAR2(6),
	PRIMARY KEY(NO),
	UNIQUE(JUMIN),
	CHECK(AREA < 5),
	FOREIGN KEY(DEPTNO) REFERENCES T_DEPT2(DCODE)
);

-- #9002
-- 제약조건명을 명시하여 정의
DROP TABLE T_EMP3 CASCADE CONSTRAINT;
CREATE TABLE T_EMP3 (
	NO NUMBER(4) CONSTRAINT EMP3_NO_PK PRIMARY KEY,
	NAME VARCHAR2(10) CONSTRAINT EMP3_NAME_NN NOT NULL,
	JUMIN VARCHAR2(13) CONSTRAINT EMP3_JUMIN_NN NOT NULL
						CONSTRAINT EMP3_JUMIN_UK UNIQUE,
	AREA NUMBER(1) CONSTRAINT EMP3_AREA_CK CHECK(AREA < 5),
	DEPTNO VARCHAR2(6) CONSTRAINT EMP3_DEPTNO_RK REFERENCES T_DEPT2(DCODE)
);

DROP TABLE T_EMP3 CASCADE CONSTRAINT;
CREATE TABLE T_EMP3 (
	NO NUMBER(4),
	NAME VARCHAR2(10) CONSTRAINT EMP3_NAME_NN NOT NULL,
	JUMIN VARCHAR2(13) CONSTRAINT EMP3_JUMIN_NN NOT NULL,
	AREA NUMBER(1),
	DEPTNO VARCHAR2(6),
	CONSTRAINT EMP3_NO_PK PRIMARY KEY(NO),
	CONSTRAINT EMP3_JUMIN_UK UNIQUE(JUMIN),
	CONSTRAINT EMP3_AREA_CK CHECK(AREA < 5),
	CONSTRAINT EMP3_DEPTNO_FK FOREIGN KEY(DEPTNO) REFERENCES T_DEPT2(DCODE)
);

-- #9003 제약조건 조회하기
SELECT OWNER, CONSTRAINT_NAME, CONSTRAINT_TYPE, STATUS
FROM USER_CONSTRAINTS 
WHERE TABLE_NAME = 'T_EMP4'
;

-- #9005 제약조건에 맞는 / 위배되는 DML 시도해보기
-- 두번 실행하면 오류 : ORA-00001: unique constraint (SCOTT0316.EMP3_NO_PK) violated
INSERT INTO T_EMP3 VALUES(1, '오라클', '1234561234567', 4, 1000);

-- ORA-00001: unique constraint (SCOTT0316.EMP3_JUMIN_UK) violated
INSERT INTO T_EMP3 VALUES(2, '오라클', '1234561234567', 4, 1000);

-- ORA-12899: value too large for column "SCOTT0316"."T_EMP3"."JUMIN" (actual: 14, maximum: 13)
INSERT INTO T_EMP3 VALUES(2, '오라클', '22222222222222', 4, 1000);

-- ORA-01438: value larger than specified precision allowed for this column
INSERT INTO T_EMP3 VALUES(2, '오라클', '2222222222222', 10, 1000);

-- ORA-02291: integrity constraint (SCOTT0316.EMP3_DEPTNO_FK) violated - parent key not found
INSERT INTO T_EMP3 VALUES(2, '오라클', '2222222222222', 3, 2000);

-- ORA-01400: cannot insert NULL into ("SCOTT0316"."T_EMP3"."NAME")
INSERT INTO T_EMP3 (NO, JUMIN, AREA, DEPTNO) VALUES (2, '3333333333333', 4, 1001);

-- INSERT뿐 아니라 UPDATE/DELETE 에서도 오류 발생 가능
UPDATE T_EMP3 SET AREA = 10 WHERE NO = 1;	-- CHECK 값 오류
SELECT * FROM T_EMP3;
-- ORA-02292: integrity constraint (SCOTT0316.EMP3_DEPTNO_FK) violated - child record found
DELETE FROM T_DEPT2 WHERE DCODE = 1000;	-- 참조되고 있는 부모를 삭제할 수 없다.

-- #9005 테이블 생성후에 ALTER 명령 사용하여 제약조건 추가 가능!
-- T_EMP4 의 NAME 에 UNIQUE 제약조건 추가
ALTER TABLE T_EMP4 ADD CONSTRAINT EMP4_NAME_UK UNIQUE(NAME);

-- #9006
-- T_EMP4 테이블의 AREA 컬럼에 NOT NULL 제약조건 추가
ALTER TABLE T_EMP4 ADD CONSTRAINT EMP4_AREA_NOT_NULL NOT NULL(AREA);
ALTER TABLE T_EMP4 MODIFY (AREA CONSTRAINT EMP4_AREA_NN NOT NULL);

-- #9007
-- 참조되는 부모테이블의 컬럼은 PRIMARY KEY 이거나 UNIQUE 해야 한다.
ALTER TABLE T_EMP4 ADD CONSTRAINT EMP4_NAME_FK FOREIGN KEY(NAME) REFERENCES T_EMP2(NAME);
-- 일단 부모테이블의 NAME 을 UNIQUE 로 바꾼뒤에 다시 실행해 보세요.
ALTER TABLE T_EMP2 ADD CONSTRAINT EMP2_NAME_UK UNIQUE(NAME);

-- #9008
DROP TABLE T_EMP3 CASCADE CONSTRAINT;
CREATE TABLE T_EMP3 (
	NO NUMBER(4) CONSTRAINT EMP3_NO_PK PRIMARY KEY,
	NAME VARCHAR2(10) CONSTRAINT EMP3_NAME_NN NOT NULL,
	JUMIN VARCHAR2(13) CONSTRAINT EMP3_JUMIN_NN NOT NULL
						CONSTRAINT EMP3_JUMIN_UK UNIQUE,
	AREA NUMBER(1) CONSTRAINT EMP3_AREA_CK CHECK(AREA < 5),
	DEPTNO VARCHAR2(6) CONSTRAINT EMP3_DEPTNO_RK REFERENCES T_DEPT2(DCODE)
						ON DELETE CASCADE	-- 부모 삭제되면 같이 삭제됨
--						ON DELETE SET NULL	-- 부모 삭제되면 NULL 값으로
);

-- #9009
-- T_EMP4 테이블의 NAME 필드의 제약조건에 부모테이블이 삭제되면 NULL이 되도록 설정하기 (ALTER 사용)
ALTER TABLE T_EMP4 DROP CONSTRAINT EMP4_NAME_FK;	-- 일단 기존 제약조건 삭제
ALTER TABLE T_EMP4 
	ADD CONSTRAINT EMP4_NAME_FK FOREIGN KEY(NAME) REFERENCES T_EMP2(NAME)
	ON DELETE SET NULL	-- 부모가 삭제되면 자식은 NULL로 변환
;

-- DISABLE NOVALIDATE
SELECT * FROM T_NOVALIDATE;
SELECT * FROM T_VALIDATE;

SELECT OWNER, CONSTRAINT_NAME ,CONSTRAINT_TYPE ,STATUS 
FROM USER_CONSTRAINTS 
WHERE TABLE_NAME = 'T_VALIDATE';

INSERT INTO T_VALIDATE VALUES(1, 'DDD');

SELECT OWNER, CONSTRAINT_NAME ,CONSTRAINT_TYPE ,STATUS 
FROM USER_CONSTRAINTS 
WHERE TABLE_NAME = 'T_NOVALIDATE';

INSERT INTO T_NOVALIDATE VALUES(1, 'DDD');

ALTER TABLE T_NOVALIDATE 
DISABLE NOVALIDATE CONSTRAINT SYS_C007031
;


SELECT * FROM T_NOVALIDATE ;

ALTER TABLE T_NOVALIDATE 
ENABLE NOVALIDATE CONSTRAINT SYS_C007031
;

DELETE FROM T_NOVALIDATE WHERE NAME = 'DDD';

CREATE TABLE T_MEMBER2 (
    mb_uid NUMBER PRIMARY KEY,
    mb_name VARCHAR2(20) NOT NULL,
    mb_jumin VARCHAR2(13) UNIQUE,
    mb_age NUMBER CHECK(mb_age > 10),
    mb_dept VARCHAR2(6) REFERENCES T_DEPT2(DCODE)
);