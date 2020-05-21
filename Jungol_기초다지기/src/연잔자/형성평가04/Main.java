package 연잔자.형성평가04;

import java.util.Scanner;

public class Main {
	/*
	 * 문제
	 * 두 정수를 입력받아
	 * 첫 번째 수는 전치증가연산자를 사용하고 두 번째 수는 후치감소연산자를 사용하여 출력하고
	 * 바뀐 값을 다시 출력하는
	 * 프로그램을 작성하시오.
	 *
	 * 입력 예
	 * 10 15
	 * 출력 예
	 * 11 15
	 * 11 14
	 */

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		System.out.println(++a + " " + b--);
		System.out.println(a + " " + b);
	}
}
