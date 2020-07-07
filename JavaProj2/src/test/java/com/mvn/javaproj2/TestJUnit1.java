package com.mvn.javaproj2;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 *
 * 1] void assertEquals(boolean expected, boolean actual)	// 같은지 체크
 * 2] void assertFalse(boolean condition)	// false 인지 체크
 * 3] void assertNotNull(Object object)		// Object 가 null 이 아닌지 체크
 * 4] void assertNull(Object object)		// Object 가 null 인지 체크
 * 5] void assertTrue(boolean condition)	// true 인지 체크
 * 6] void fail()	// 무조건 fail
 * 
 * @author trowe
 *
 */
public class TestJUnit1 {

	@Test
	public void test() {
		int num = 5;
		String temp = null;
		String str = "안녕하세요";
		
		assertEquals("안녕하세요", str);	// equals 면 통과
		assertFalse(num > 6);	// false 면 통과
//		assertFalse(num > 2);	// true 면 테스트 통과 못 함.
		assertNull(temp);		// Null 이면 통과
		temp = "Hi";
		assertNotNull(temp);	// NotNull 이면 통과 (Null 이 아니면 통과)
		/**
		 * double/float 실수 연산 결과값의 오차범위 delta 값
		 */
//		assertEquals(3.0, 12.3 / 4.1);	// 실수 연산의 문제가 있기 때문에 같은 값이 나오지 않는다.
		assertEquals(3.0, 12.3 / 4.1, 0.00001);	// delta 값을 설정해주면 해당 오차 범위까지 허용하기 때문에 같다고 볼 수 있다. 
		
		
		
	} // end test()

} // end Test Case
