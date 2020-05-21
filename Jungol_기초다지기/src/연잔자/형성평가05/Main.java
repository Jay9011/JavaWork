package 연잔자.형성평가05;

import java.util.Scanner;

public class Main {
	/*
	 * 문제
	 * 민수와 기영이의 키와 몸무게를 입력받아 민수가 키도 크고 몸무게도 크면 1 그렇지 않으면 0을 출력하는 프로그램을 작성하시오.
	 * (JAVA는 1 이면 true, 0 이면 false를 출력한다.)
	 *
	 * 입력 예
	 * 150 35
	 * 145 35
	 *
	 * 출력 예
	 * 0
	 *
	 * Hint!
	 * 관계 연산자와 논리 연산자를 함께 이용한다.
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int aHeight = sc.nextInt();
		int aWeight= sc.nextInt();
		int bHeight = sc.nextInt();
		int bWeight = sc.nextInt();
		boolean isAH = aHeight > bHeight;
		boolean isAW = aWeight > bWeight;

		System.out.println(isAH & isAW);
	}

}
