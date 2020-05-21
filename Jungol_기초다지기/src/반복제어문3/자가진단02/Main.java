package 반복제어문3.자가진단02;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		/*
		 * 문제
		 * 자연수 n을 입력받아서 n줄만큼 다음과 같이 출력하는 프로그램을 작성하시오.
		 *
		 *
		 * 입력 예
		 * 5
		 * 출력 예
		 *
		 * *
		 * **
		 * ***
		 * ****
		 * *****
		 */

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int count = 1;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < count; j++) {
				System.out.print("*");
			} // end for // 한줄 반복
			count++;
			System.out.println();
		} // end for // n번 반복


		sc.close();
	}

}
