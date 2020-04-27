CREATE VIEW V_PROF
AS
	SELECT PROFNO , NAME , EMAIL , HPAGE 
	FROM T_PROFESSOR 
;

SELECT * FROM V_PROF;

SELECT TNAME FROM TAB;	-- VIEW 확인 가능

CREATE OR REPLACE VIEW V_PROF
AS
	SELECT PROFNO , NAME , EMAIL , HPAGE 
	FROM T_PROFESSOR 
;
-- VIEW 생성시 별도로 컬럼 이름을 지정해줄수 있다.
CREATE OR REPLACE VIEW V_PROF("교수번호", "이름", "이메일", "홈페이지")
AS
	SELECT PROFNO , NAME , EMAIL , HPAGE 
	FROM T_PROFESSOR 
;

SELECT * FROM V_PROF;

-- #8102) t_professor, t_department 테이블을 join 하여 교수번호와 교수이름과 소속학과 이름을 조회하는 view 를 생성하세요.  
-- (이름: v_prof_dept)
CREATE OR REPLACE VIEW V_PROF_DEPT
AS SELECT P.PROFNO "교수 번호", P.NAME "교수 이름", D.DNAME "학과 이름"
	FROM T_PROFESSOR P, T_DEPARTMENT D
	WHERE P.DEPTNO = D.DEPTNO 
;
-- 확인
SELECT * FROM V_PROF_DEPT
;

-- #8103) t_student, t_department 테이블 : 학과별로 학생들의 최대키와 최대몸무게, 학과 이름을 출력하세요
SELECT D.DNAME "학과명", S.MAX_HEIGHT "최대키", S.MAX_WEIGHT "최대 몸무게"
FROM (SELECT DEPTNO1 , MAX(HEIGHT) MAX_HEIGHT , MAX(WEIGHT) MAX_WEIGHT 
		FROM T_STUDENT 
		GROUP BY DEPTNO1 ) S,
	T_DEPARTMENT D
WHERE S.DEPTNO1 = D.DEPTNO
;

-- #8104) t_student, t_department 테이블 : 학과별(deptno1)로 가장 키가 큰 학생들의 이름과 키, 학과이름을 인라인뷰 를 사용하여 다음과 같이 출력하세요 
SELECT D.DNAME "학과명", A.MAX_HEIGHT "최대 키", S.NAME "이름", S.HEIGHT "키"
FROM
	(SELECT DEPTNO1 , MAX(HEIGHT) "MAX_HEIGHT" 
		FROM T_STUDENT 
		GROUP BY DEPTNO1) A,
	T_STUDENT S,
	T_DEPARTMENT D
WHERE S.DEPTNO1 = A.DEPTNO1 AND S.HEIGHT = A.MAX_HEIGHT AND S.DEPTNO1 = D.DEPTNO 
;

-- #8105) t_student 테이블 : 학생의 키가 동일 학년의 평균 키보다 큰 학생들의 학년과 이름과 키, 해당 학년의 평균키를 출력하되, inline view 를 사용해서 아래와 같이 출력하세요. 단 학년 칼럼은 오름 차순으로 정렬.
SELECT S.GRADE "학년", S.NAME "이름", S.HEIGHT "키", A.AVG_HEIGHT "평균키"
FROM
	(SELECT GRADE , AVG(HEIGHT) "AVG_HEIGHT"
		FROM T_STUDENT 
		GROUP BY GRADE) A,
	T_STUDENT S
WHERE S.HEIGHT > A.AVG_HEIGHT AND S.GRADE = A.GRADE
ORDER BY 1
;