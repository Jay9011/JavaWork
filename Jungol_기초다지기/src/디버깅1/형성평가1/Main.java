package 디버깅1.형성평가1;

import java.util.Scanner;

public class Main {
	/*
	 * 문제
	 * 정수로 된 3과목의 점수를 입력받아 평균을 구한 후 반올림하여 소수 첫째자리까지 출력하는 프로그램을 작성하시오.
	 *
	 *
	 * 입력 예
	 * 70 95 65
	 * 출력 예
	 * 76.7
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();

		System.out.printf("%.1f", (a + b + c)/3.0);

		sc.close();
	}

}
