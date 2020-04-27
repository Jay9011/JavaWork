package 반복제어문2.자가진단05;

import java.util.Scanner;

public class Main {
	/*
	 * 문제
	 * 10개의 정수를 입력받아 3의 배수의 개수와 5의 배수의 개수를 각각 출력하는 프로그램을 작성하시오
	 * 
	 * 입력 예
	 * 10 15 36 99 100 19 46 88 87 13
	 * 
	 * 출력 예
	 * Multiples of 3 : 4
	 * Multiples of 5 : 3
	 */

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] num = new int[10];
		
		int threeMul = 0;
		int fiveMul = 0;
		
		for (int i = 0; i < num.length; i++) {
			num[i] = sc.nextInt();
			if(num[i] % 3 == 0) {
				threeMul++;
			}
			if(num[i] % 5 == 0) {
				fiveMul++;
			}
		}
		
		System.out.print("Multiples of 3 : " + threeMul + "\n");
		System.out.print("Multiples of 5 : " + fiveMul + "\n");
		
		sc.close();
	}

}
