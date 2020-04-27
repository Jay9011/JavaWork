package 함수1.자가진단01;

import java.util.Scanner;

public class Main {
	public static void print() {
		System.out.println("~!@#$^&*()_+|");
	}
	
	public static void main(String[] args) {
		/*
		 * 문제
		 * 문자열 "~!@#$^&*()_+|" 를 출력하는 함수를 작성하고 정수를 입력받아 입력받은 수만큼 함수를 호출하는 프로그램을 작성하시오.
		 * 
		 * 문자열을 잘 확인하세요.
		 * 
		 * 입력 예
		 * 3
		 * 
		 * 출력 예
		 * ~!@#$^&*()_+|
		 * ~!@#$^&*()_+|
		 * ~!@#$^&*()_+|
		 */
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			print();
		}
		sc.close();
	}
}
