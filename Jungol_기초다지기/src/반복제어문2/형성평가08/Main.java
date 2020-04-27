package 반복제어문2.형성평가08;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		/*
		 * 문제
		 * 행과 열의 수를 입력받아 다음과 같이 출력하는 프로그램을 작성하시오.
		 * 
		 * 입력 예
		 * 3 4
		 * 
		 * 출력 예
		 * 1 2 3 4
		 * 2 4 6 8
		 * 3 6 9 12
		 */

		Scanner sc = new Scanner(System.in);
		
		int column = sc.nextInt();
		int row = sc.nextInt();
		
		for (int i = 1; i <= column; i++) {
			for (int j = 1; j <= row; j++) {
				System.out.print(i * j + " ");
			}
			System.out.println();
		}
		
		sc.close();
	}

}
