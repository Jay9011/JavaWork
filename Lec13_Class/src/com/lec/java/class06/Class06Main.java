package com.lec.java.class06;

import java.util.Scanner;

public class Class06Main {

	public static void main(String[] args) {
		System.out.println("클래스 연습 : 성적처리");
		
		Score score1 = new Score();
		score1.displayInfo();
		
		
		System.out.println();
		Score score2 = new Score("김남승", 80, 41, 91);
		score2.displayInfo();

		int total = score2.calcTotal();
		double avg = score2.calcAvg();
		System.out.println("총점: " + total);
		System.out.println("평균: " + avg);

		System.out.println("프로그램 종료");
	} // end main()

} // end class Clas06Main










