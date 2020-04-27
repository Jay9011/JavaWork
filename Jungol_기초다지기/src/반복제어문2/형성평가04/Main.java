package 반복제어문2.형성평가04;

import java.util.Scanner;

public class Main {
//	문제
//	100 이하의 자연수 n을 입력받고 n개의 정수를 입력받아 평균을 출력하는 프로그램을 작성하시오.
//	(평균은 반올림하여 소수 둘째자리까지 출력하도록 한다.)
//	
//	입력 예
//	3
//	99 65 30
//	
//	출력 예
//	64.67
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int sum = 0;
		double avg = 0.0;
		
		for (int i = 0; i < num; i++) {
			int nextNum = sc.nextInt();
			sum += nextNum;
		}
		
		avg = (double)sum / num;
		
		System.out.printf("%.2f", avg);
		
		sc.close();
	}
}
