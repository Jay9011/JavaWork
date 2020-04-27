package 반복제어문3.형성평가04;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		/*
		 * 자연수 n을 입력받아 "출력 예"와 같이 출력되는 프로그램을 작성하시오.
		 * 주의! '*'과 '*'사이에 공백이 없고 줄사이에도 빈줄이 없다.
		 * 
		 * 입력 예
		 * 3
		 * 
		 * 출력 예
		 *	*****	3 + 2					*******
		 *	 ***	3		(1 + 3 + 1)		 *****
		 *	  *		3 - 2	(3 + 1 + 3)		  ***
		 *	 ***	3		(1 + 3 + 1)		   *
		 *	*****	3 + 2					  ***
		 *									 *****
		 *									*******
		 */

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		sc.close();
	}

}
