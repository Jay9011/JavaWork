package com.mvn.javaproj2;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * JUnit 파라미터화 테스트(Parameterized Test)
 * 
 * 동일한 테스트를 @Parameters 컬렉션의 원소 개수만큼 반복 실행
 * Parameterized 클래스는 JUnit이 제공하는 많은 테스트 러너중 하나
 */



@RunWith(value = Parameterized.class)
public class TestParameter {

	private int expected;
	private int valueOne;
	private int valueTwo;
	
	@Parameters
	public static Collection<Integer[]> getTestParameters(){
		return Arrays.asList(new Integer[][] {
			{2, 1, 1},	// expected, valueOne, valueTwo
			{3, 2, 1},	// expected, valueOne, valueTwo
			{4, 3, 1},	// expected, valueOne, valueTwo
			{5, 2, 3},	// expected, valueOne, valueTwo
			{3, 1, 1}	// expected, valueOne, valueTwo
		});
	} // end getTestParameters()
	
	public TestParameter(int expected, int valueOne, int valueTwo) {
		super();
		System.out.println("TestParameter() 생성");
		this.expected = expected;
		this.valueOne = valueOne;
		this.valueTwo = valueTwo;
	}

	@Test
	public void sum() {
		Calculator cal = new Calculator();
		assertEquals(expected, cal.add(valueOne, valueTwo));
		System.out.println("테스트 통과 : " + expected + "," + valueOne + "," + valueTwo);
	} // end sum()
	
	@BeforeClass
	public static void beforeClass() {
		System.out.println("@beforeClass");
	} // end beforeClass()


} // end Test Case
