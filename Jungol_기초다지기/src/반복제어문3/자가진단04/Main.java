package 반복제어문3.자가진단04;

import java.util.Scanner;

public class Main {

//	문제
//	자연수 n을 입력받아서 다음과 같이 출력하는 프로그램을 작성하시오.
//
//
//	입력 예
//	3
//	출력 예
//	***
//	 **
//	  *
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int count = n;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n-count; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < count; j++) {
				System.out.print("*");
			}
			count--;
			System.out.println();
		}
		sc.close();
	}
}
