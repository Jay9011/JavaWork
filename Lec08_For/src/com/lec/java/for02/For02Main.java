package com.lec.java.for02;

public class For02Main {

	public static void main(String[] args) {
		System.out.println("For문 - 구구단 출력");
		
		// 2 X 1 = 2
		// 2 X 2 = 4
		// ...
		// 2 X 9 = 18

		System.out.println();
		
		for (int i = 1; i <= 9; i++) {
			System.out.println("2 X " + i + " = " + (2 * i));
		}
		
		System.out.println();
		
		//구구단 4단
		for (int i = 1; i <= 9; i++) {
			System.out.println("4 X " + i + " = " + (4 * i));
		}
		
		System.out.println();
		
		// 2 X 2 = 4
		// 3 X 3 = 9
		// ...
		// 9 X 9 = 81
		for (int i = 2; i <= 9; i++) {
			System.out.println(i + " X " + i + " = " + (i * i));
		}
		
	} // end main()

} // end class For02Main












