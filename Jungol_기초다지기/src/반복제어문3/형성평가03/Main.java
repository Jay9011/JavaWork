package 반복제어문3.형성평가03;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		/*
		 * 문제
		 * 자연수 n을 입력받아 "출력 예"와 같이 출력되는 프로그램을 작성하시오.
		 * 주의! '*'과 '*'사이에 공백이 없고 줄사이에도 빈줄이 없다.
		 * 
		 * 입력 예
		 * 3
		 * 
		 * 출력 예
		 *	*			*		*
		 *	**			**		**
		 *	***			*		***
		 *	**					****
		 *	*					***
		 *						**
		 *						*
		 *	3 + 2		2 + 1	4 + 3
		 */

		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		for (int i = 1; i <= n + (n-1); i++) {
			if(i <= n) {
				for (int j = 1; j <= i; j++) {
					System.out.print("*");
				}
			}else {
				for (int j = 1; j <= (2 * n) - i; j++) {
					System.out.print("*");
				}
			}
			System.out.println();
		}

		sc.close();
	}

}
