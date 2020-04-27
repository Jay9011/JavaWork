package 반복제어문1.자가진단03;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		/*
		 * 문제
		 * 한 개의 정수를 입력받아 양수(positive integer)인지 
		 * 음수(negative number)인지 출력하는 작업을 반복하다가 
		 * 0이 입력되면 종료하는 프로그램을 작성하시오.
		 * 
		 * 입출력예의 진한글씨는 출력값입니다.​
		 * 
		 * 입·출력 예
		 * number? 10
		 * positive integer
		 * number? -10
		 * negative number
		 * number? 0
		 */
				
		Scanner sc = new Scanner(System.in);
		
		int num = 0;
		
		do {
			System.out.print("number? ");
			num = sc.nextInt();
			if(num == 0) break;
			if(num < 0) {
				System.out.println("negative number");
			}else {
				System.out.println("positive integer");
			}
		}while (num != 0);
		
		sc.close();
	}
}
