package 반복제어문3.자가진단07;

import java.util.Scanner;

public class Main {
//	문제
//	자연수 n을 입력받아서
//	n개의 줄에 n+1개의 숫자 혹은 문자로 채워서
//	다음과 같이 출력하는 프로그램을 작성하시오.
//
//	입력 예
//	3
//	출력 예
//	1 2 3 A
//	4 5 B C
//	6 D E F
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int counter = n;
		int num = 1;
		char temp = 65;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n-i; j++) {
				System.out.print(num + " ");
				num++;
			}
			for (int j = 0; j < i+1 ; j++) {
				System.out.print(temp + " ");
				temp++;
			}
			System.out.println();
			counter++;
		}
		sc.close();
	}
}
