package com.lec.java.inner03;

public class TestOuter {
	private int value;		// 1. Outer value
	
	public TestOuter(int value) {
		this.value = value;
	} // testOuter(int)
	
	public int getValue() {
		return value;
	} // getValue()
	
	// 멤버 내부 클래스
	public class TestInner{
		private int value;	// 2. Inner value

		public TestInner(int value) {
			this.value = value;
		}
		
		public void printValue() {
			int value = 10;	// 3. 지역변수 value
			System.out.println("value = " + value);
			System.out.println("this.value = " + this.value);
			System.out.println("TestOuter.this.value = " + TestOuter.this.value);
		}
		
	}
	

} // end class TestOuter














