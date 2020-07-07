package com.mvn.javaproj2;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.TestCase;

public class TestJUnit2 extends TestCase{

	@Before
	public void before() {
		System.out.println("[before()]");
	}
	@After
	public void after() {
		System.out.println("[after()]");
	}
	@BeforeClass
	public static void beforeClass() {
		System.out.println("<<beforeClass()>>");
	}
	@AfterClass
	public static void afterClass() {
		System.out.println("<<afterClass()>>");
	}
	@Test
	public void testA() {
		System.out.println("TestA()");
		System.out.println("No. of Test Case = " + this.countTestCases());
		System.out.println("Test Case Name = " + this.getName());
	}
	@Test
	public void testB() {
		System.out.println("TestB()");
		System.out.println("No. of Test Case = " + this.countTestCases());
		setName("B테스트 입니다.");
		System.out.println("Test Case Name = " + this.getName());
	}
	@Test
	public void testC() {
		System.out.println("TestC()");
		System.out.println("No. of Test Case = " + this.countTestCases());
		System.out.println("Test Case Name = " + this.getName());
	}
	@Test
	public void testD() {
		System.out.println("TestD()");
		System.out.println("No. of Test Case = " + this.countTestCases());
		System.out.println("Test Case Name = " + this.getName());
	}

} // end Test Case
