-- INITCAP() 함수

-- #4101
SELECT id, INITCAP(ID ) 
FROM T_STUDENT 
WHERE DEPTNO1 = 201;

-- LOWER(), UPPER()
-- #4103
SELECT name, id, UPPER(ID ), lower(ID ) 
FROM T_STUDENT 
WHERE DEPTNO1 = 201;

-- LENGTH(), LENGTHB()
-- #4104
SELECT NAME "이름" , ID , LENGTH(ID ) "글자수" 
FROM T_STUDENT 
WHERE LENGTH(ID ) >= 9;

-- #4105
SELECT name 이름, LENGTH (NAME ), lengthb(NAME )
FROM T_STUDENT 
WHERE DEPTNO1 = '201';

-- CONCAT() 함수
-- #4106
SELECT CONCAT(name, "POSITION") 
FROM T_PROFESSOR 
WHERE DEPTNO = 101;

-- SUBSTR() 함수
SELECT SUBSTR('ABCDE', 2, 3)
FROM dual;

SELECT SUBSTR('ABCDE', 20, 3)
FROM dual;

SELECT SUBSTR('ABCDE', -2, 3)
FROM dual;

-- #4107
SELECT NAME ,SUBSTR(JUMIN, 1, 6) 
FROM T_STUDENT 
WHERE DEPTNO1 = '101';

-- #4108
SELECT NAME ,SUBSTR(JUMIN, 1, 6) 
FROM T_STUDENT
WHERE SUBSTR(JUMIN , 3, 2) = '08' ; 

-- #4109
SELECT NAME ,JUMIN
FROM T_STUDENT 
WHERE GRADE = 4 AND SUBSTR(JUMIN , 7, 1) IN (2, 4); 

SELECT * FROM T_STUDENT ;

-- INSTR() 함수
SELECT INSTR('A*B*C*', '*', 1, 1) FROM DUAL;
SELECT INSTR('A*B*C*', '*', 1, 2) FROM DUAL;
SELECT INSTR('A*B*C*', '*', 3, 2) FROM DUAL;
SELECT INSTR('A*B*C*', '*', -4, 1) FROM DUAL;
SELECT INSTR('A*B*C*', '*', -4, 2) FROM DUAL;
SELECT INSTR('A*B*C*', '*', -2, 2) FROM DUAL;

-- #4110
SELECT NAME, TEL, INSTR(TEL , ')', 1, 1) AS "위치"
FROM T_STUDENT 
WHERE DEPTNO1 = 101;

SELECT NAME, TEL, INSTR(TEL , ')') AS "위치"
FROM T_STUDENT 
WHERE DEPTNO1 = 101;

-- #4111
SELECT NAME , TEL , SUBSTR(TEL, 1,INSTR(TEL ,')')-1) AS "지역번호" 
FROM T_STUDENT 
WHERE DEPTNO1 = 101;

SELECT LPAD('ABC', 10, 'ABC') 
FROM DUAL;

-- LTRIM(), RTRIM(), TRIM()
SELECT LTRIM('슈퍼슈퍼슈가맨', '퍼슈가') LTRIM , 
		LTRIM('슈퍼슈퍼슈가맨', '슈') LTRIM ,
		LTRIM('       슈퍼슈가맨', ' ') LTRIM ,
		LTRIM('       슈퍼슈가맨') LTRIM, 
		RTRIM('우측 공백 제거         ') RTRIM,
		TRIM('       공백 제거     ') TRIM,
		LTRIM('********1000', '*') LTRIM
FROM DUAL;

-- #4116
SELECT *
FROM T_DEPT2 ;

SELECT DNAME ,RTRIM(DNAME ,'부팀') AS RTRIM예제 
FROM T_DEPT2 ;

-- REPLACE
SELECT REPLACE ('슈퍼맨 슈퍼걸', '슈퍼', '파워')
FROM DUAL;

SELECT REPLACE ('아버지가 방에 들어간다', ' ', '')
FROM DUAL;

-- #4118
SELECT REPLACE (NAME, SUBSTR(NAME, 1, 1), '#')
FROM T_STUDENT 
WHERE DEPTNO1 = 102;

-- #4119
SELECT REPLACE (NAME , SUBSTR(NAME ,2 ,1), '#' )
FROM T_STUDENT 
WHERE DEPTNO1 = 101;

-- #4120
SELECT NAME , REPLACE (JUMIN , SUBSTR(JUMIN , 7), '*******' )
FROM T_STUDENT 
WHERE DEPTNO1 = 101;

-- #4121
SELECT NAME, TEL, REPLACE (TEL , SUBSTR(TEL , INSTR(TEL,')')+1, 3), '###' ) AS "전화번호"
FROM T_STUDENT 
WHERE DEPTNO1 = 102;