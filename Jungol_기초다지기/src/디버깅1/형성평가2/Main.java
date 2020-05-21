package 디버깅1.형성평가2;

import java.util.Scanner;

public class Main {
	/*
	 * 문제
	 * 실수로 된 3과목의 점수를 입력받아 총점은 정수부분의 합계를 출력하고 평균은 실수의 평균을 구한 뒤 정수부분만 출력하는 프로그램을
	 * 작성하시오.
	 *
	 *
	 * 입력 예
	 * 70.5 95.5 68.5
	 * 출력 예
	 * sum 233
	 * avg 78
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double a = sc.nextDouble();
		double b = sc.nextDouble();
		double c = sc.nextDouble();
		int sum = (int)a + (int)b + (int)c;
		double avg = (a+b+c)/3.0;

		System.out.println("sum " + sum);
		System.out.println("avg " + (int)avg);


		sc.close();
	}

}
