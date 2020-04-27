package com.lec.java.final01;

public class Final01Main {
	
	// final 멤버변수
	// 멤버변수는 선언과 동시에 초기화 해야함.
	final int NUM = 1;	// final 변수는 가능하면 대문자로 사용하도록 한다.
	
	public static void main(String[] args) {
		System.out.println("final: 변경할 수 없는 상수");
		
		int num1 = 1;
		num1 = 10;
		
		final int num2 = 1;
//		num2 = 10;	// cannot be assigned. // final 변수이기 때문에 변경할 수 없다
		
		final int num3;
		num3 = 1;	// final 변수를 먼저 선언하고 이후 초기화 가능! (초기화를 한 번만 시킬 수 있는 수식어 final)

	} // end main()

} // end class Final01Main










