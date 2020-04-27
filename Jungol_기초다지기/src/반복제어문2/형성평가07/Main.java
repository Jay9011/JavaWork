package 반복제어문2.형성평가07;

import java.util.Scanner;

public class Main {
	/*
	 * 문제
	 * 한 개의 자연수를 입력받아 그 수의 배수를 차례로 10개 출력하는 프로그램을 작성하시오.
	 * 
	 * 
	 * 입력 예
	 * 5
	 *
	 * 출력 예
	 * 5 10 15 20 25 30 35 40 45 50
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 1; i <= 10; i++) {
			System.out.print(n*i + " ");
		}
		sc.close();
	}
}
