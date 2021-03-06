SELECT 1 + 1 FROM DUAL ;
SELECT '1' + 1 FROM DUAL ;

SELECT TO_NUMBER('1') + 1 FROM DUAL ;

SELECT SYSDATE, TO_CHAR(SYSDATE, 'YYYY') AS "연도 4자리" 
FROM DUAL 
;

SELECT SYSDATE,
		TO_CHAR(SYSDATE, 'YYYY') AS "연도 4자리" ,
		TO_CHAR(SYSDATE, 'RRRR') AS "연도 Y2K버그 이후",
		TO_CHAR(SYSDATE, 'YY') AS "연도 2자리",
		TO_CHAR(SYSDATE, 'YEAR') AS "연도 영문"
FROM DUAL 
;

SELECT
	TO_CHAR(SYSDATE, 'DD') AS "일 숫자 2자리",
	TO_CHAR(SYSDATE, 'MM') AS "월 숫자 2자리",
	TO_CHAR(SYSDATE, 'DAY') AS "요일",
	TO_CHAR(SYSDATE, 'Dy') AS "요일 앞자리",
	TO_CHAR(SYSDATE, 'DDth') AS "몇번째날",
	TO_CHAR(SYSDATE, 'MON') 월3자리,  -- 7월
	TO_CHAR(SYSDATE, 'MONTH')  월전체,  -- 7월
	TO_CHAR(SYSDATE, 'MON', 'NLS_DATE_LANGUAGE=ENGLISH') 월영문3자리,  -- JUL
	TO_CHAR(SYSDATE, 'MONTH', 'NLS_DATE_LANGUAGE=ENGLISH')  "월영문전체(대)", -- JULY
	TO_CHAR(SYSDATE, 'month', 'NLS_DATE_LANGUAGE=ENGLISH')  "월영문전체(소)",  -- july
	TO_CHAR(SYSDATE, 'Month', 'NLS_DATE_LANGUAGE=ENGLISH')  "월영문전체(첫글자대)" -- July
FROM DUAL
;

SELECT 
	TO_CHAR(SYSDATE, 'HH24') 시24hr,
	TO_CHAR(SYSDATE, 'HH')  시12hr,
	TO_CHAR(SYSDATE, 'MI') 분,
	TO_CHAR(SYSDATE, 'SS') 초,
	TO_CHAR(sysdate, 'HH:MI:SS') 
FROM dual;

-- #4301
SELECT TO_CHAR(SYSDATE, 'YY/MM/DD') AS "SYSDATE",
	TO_CHAR(SYSDATE, 'YYYY-MM-DD HH:MI:SS') AS "날짜",
	TO_CHAR(SYSDATE, 'YYYY"년"MM"월"DD"일" HH24"시"MI"분"SS"초"') 날짜
FROM DUAL
;

-- #4302
SELECT NAME, TO_CHAR(BIRTHDAY, 'YYYY-MM-DD') AS 생일 
FROM T_STUDENT 
WHERE TO_CHAR(BIRTHDAY,'MM') = '03'
;

-- TO_CHAR : 대소문자 지정예
SELECT
SYSDATE,
TO_CHAR(SYSDATE, 'Dy Month DD, YYYY', 'NLS_DATE_LANGUAGE=ENGLISH') AS A1,
TO_CHAR(SYSDATE, 'dy month dd, YYYY', 'NLS_DATE_LANGUAGE=ENGLISH') AS A2,
TO_CHAR(SYSDATE, 'DY MONTH DD, YYYY', 'NLS_DATE_LANGUAGE=ENGLISH') AS A3
FROM DUAL;

SELECT 
	1234,
	TO_CHAR(1234, '99999') "9하나당 1자리",
	TO_CHAR(1234, '099999') "빈자리를 0으로",
	TO_CHAR(1234, '$99999') "빈자리를 $으로",
	TO_CHAR(1234.1256, '99999.99') "소숫점이하 2자리",
	TO_CHAR(1234, '99,999') "천단위 구분기호",
	TO_CHAR(123456789, '99,999') "천단위 구분기호"
FROM DUAL;

SELECT NAME ,TO_CHAR((PAY*12)+NVL(BONUS, 0) ,'9,999') 
FROM T_PROFESSOR 
WHERE DEPTNO = 101
;

SELECT TO_NUMBER('123.44') 
FROM DUAL;

SELECT TO_DATE('2020-02-29', 'YYYY-MM-DD') TO_DATE
FROM DUAL;

SELECT NAME ,
		TO_CHAR(HIREDATE ,'YYYY-MM-DD') AS "입사일",
		TO_CHAR(PAY * 12, '99,999') AS "연봉",
		TO_CHAR(PAY * 12 * 1.1 , '99,999') AS "연봉"
FROM T_PROFESSOR 
--WHERE HIREDATE < TO_DATE('2000', 'YYYY') 
WHERE TO_CHAR(HIREDATE , 'YYYY') < '2000' 
;