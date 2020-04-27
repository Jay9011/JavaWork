package 반복제어문2.자가진단01;

import java.util.Scanner;

public class Main {
	/*
	 * 문제
	 * 문자를 입력받아서 입력받은 문자를 20번 반복하여 출력하는 프로그램을 작성하시오.
	 * 
	 * 입력 예
	 * A
	 * 
	 * 출력 예
	 * AAAAAAAAAAAAAAAAAAAA
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String c = sc.next();
		
		for (int i = 0; i < 20; i++) {
			System.out.print(c);
		}
		
		sc.close();
	}
}
