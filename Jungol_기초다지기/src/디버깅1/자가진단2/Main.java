package 디버깅1.자가진단2;

import java.util.Scanner;

public class Main {
	/*
	 * 문제
	 * 2개의 정수를 입력받아서 첫 번째 수를 두 번째 수로 나눈 몫을 출력하고 첫 번째 수를 실수로 변환하여두 번째 수로 나눈 값을 구한 후
	 * 반올림하여 소수 둘째자리까지 출력하는 프로그램을 작성하고 프로그램내용에 관한 설명을 주석으로 표시하시오.
	 *
	 *
	 * 입력 예
	 * 11 3
	 * 출력 예
	 * 3 3.67
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int x = sc.nextInt();

		System.out.println(num/x);
		System.out.printf("%.2f", (double)num/x);
		sc.close();
	}
}
