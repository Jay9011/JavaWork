-- #7201) t_student 테이블을 조회하여 각 학년별로 최대 키를 가진 학생들의 학년과 이름과 키를 출력하세요, 학년 오름차순으로 출력
SELECT GRADE , MAX(HEIGHT)
FROM T_STUDENT 
GROUP BY GRADE
;

SELECT GRADE "학년", NAME "이름", HEIGHT "키"
FROM T_STUDENT 
WHERE (GRADE, HEIGHT) IN (SELECT GRADE , MAX(HEIGHT)
							FROM T_STUDENT 
							GROUP BY GRADE)
ORDER BY "학년" ASC							
;

-- #7202) t_professor , t_department 테이블 :  각 학과별로 입사일이 가장 오래된 교수의 교수번호와 이름, 학과명을 출력하세요.  단 학과이름 순으로 오름차순 정렬하세요
SELECT * FROM T_PROFESSOR ;
SELECT DEPTNO , MIN(HIREDATE) 
FROM T_PROFESSOR
GROUP BY DEPTNO
;
SELECT P.PROFNO "교수 번호" , P.NAME "교수명", P.HIREDATE "입사일", D.DNAME "학과명"
FROM T_PROFESSOR P, T_DEPARTMENT D
WHERE (D.DEPTNO , P.HIREDATE) IN (SELECT DEPTNO , MIN(HIREDATE) 
								FROM T_PROFESSOR
								GROUP BY DEPTNO)
ORDER BY "학과명" ASC 								
;

-- #7203)  t_emp2 테이블 : 직급별로 해당직급에서 최대 연봉을 받는 직원의 이름과 직급, 연봉을 출력하세요,  단, 연봉순으로 오름차순 정렬하세요
SELECT EMP_TYPE, MAX(PAY) 
FROM T_EMP2
GROUP BY EMP_TYPE
;
SELECT NAME "사원명", POST "직급", PAY "연봉"
FROM T_EMP2 
WHERE (POST ,PAY ) IN (SELECT POST, MAX(PAY) 
							FROM T_EMP2
							GROUP BY POST)
ORDER BY "연봉" ASC							
;

-- #7204)  t_emp2, t_dept2 테이블 : 각 부서별 평균 연봉을 구하고 그 중에서 평균 연봉이 가장 적은 부서의 평균연봉보다 적게 받는 직원들의 부서명, 직원명, 연봉을 출력 하세요
SELECT DEPTNO , AVG(PAY) 
FROM T_EMP2 
GROUP BY DEPTNO
;

SELECT DEPTNO, AVGPAY 
FROM (SELECT DEPTNO , AVG(PAY) "AVGPAY" 
		FROM T_EMP2 
		GROUP BY DEPTNO)
--WHERE AVGPAY = MIN(AVGPAY)
;

SELECT D.DNAME "부서명", E.NAME "직원명", E.PAY "연봉"
FROM T_EMP2 E, T_DEPT2 D
WHERE E.DEPTNO = D.DCODE AND 
	E.PAY <ALL (SELECT AVG(PAY) 
				FROM T_EMP2 
				GROUP BY DEPTNO)
ORDER BY E.PAY
;

-- #7205) t_emp2 테이블 : 직원들 중에서 자신의 직급의 평균연봉과 같거나 많이 받는 사람들의 이름과 직급, 현재 연봉을 출력하세요.
SELECT AVG(B.PAY) 
FROM T_EMP2 B
WHERE B.POST = '과장'
;

SELECT A.NAME "사원이름", NVL(A.POST, ' ') "직급", A.PAY "급여"
FROM T_EMP2 A
WHERE A.PAY >= (SELECT AVG(B.PAY) 
				FROM T_EMP2 B
				WHERE NVL(B.POST, ' ') = NVL(A.POST, ' '))
;

-- #7206) t_emp2, t_dept2 테이블: 조회하여 사원들의 이름과 부서 이름을 출력
SELECT E.NAME "사원이름", (SELECT D.DNAME
							FROM T_DEPT2 D
							WHERE E.DEPTNO = D.DCODE ) "부서이름"
FROM T_EMP2 E
;