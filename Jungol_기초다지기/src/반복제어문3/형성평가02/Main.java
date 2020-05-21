package 반복제어문3.형성평가02;

import java.util.Scanner;

public class Main {
//	문제
//	1부터 100까지의 정수 중 한 개를 입력받아
//	100 보다 작은 배수들을 차례로 출력하다가
//	10 의 배수가 출력되면 프로그램을 종료하도록
//	프로그램을 작성하시오.
//
//	입력 예
//	7
//	출력 예
//	7 14 21 28 35 42 49 56 63 70
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int i = 1;
		while(true) {
			int number = num * i;
			if(number > 100) break;
			System.out.print(number + " ");
			if(number % 10 == 0) break;
			i++;
		}
		sc.close();
	}

}
