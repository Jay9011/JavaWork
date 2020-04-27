package 반복제어문2.형성평가06;

import java.util.Scanner;

public class Main {
//	문제
//	두 개의 정수를 입력받아 두 정수 사이(두 정수를 포함)에 3의 배수이거나 5의 배수인 수들의 합과 평균을 출력하는 프로그램을 작성하시오.
//
//	(평균은 반올림하여 소수 첫째자리까지 출력한다.)
//	
//	입력 예
//	10 15
//	
//	출력 예
//	sum : 37
//	avg : 12.3
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		int min = (num1 < num2) ? num1 : num2; 
		int max = (num1 > num2) ? num1 : num2; 
		int sum = 0;
		int cnt = 0;
		
		for (int i = min; i <= max; i++) {
			if(i % 3 ==0) {
				sum += i;
				cnt++;
			}else if(i % 5 == 0) {
				sum += i;
				cnt++;
			}
		}
		
		System.out.println("sum : " + sum);
		System.out.printf("avg : %.1f", (double)sum/cnt);
		
		sc.close();
	}
}
