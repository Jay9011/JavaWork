package 반복제어문2.자가진단04;

import java.util.Scanner;

public class Main {
	/*
	 * 문제
	 * 100 이하의 정수를 입력받아서 입력받은 정수부터 100까지의 합을 출력하는 프로그램을 작성하시오.
	 * 
	 * 입력 예
	 * 95
	 * 
	 * 출력 예
	 * 585
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		int result = 0;
		for (int i = num; i <= 100; i++) {
			result += i;
		}
		System.out.println(result);
		
		sc.close();
	}

}
