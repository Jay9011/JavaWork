package 반복제어문2.형성평가02;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// 100 이하의 두 개의 정수를 입력받아 작은 수부터 큰 수까지 차례대로 출력하는 프로그램을 작성하시오.
		
		Scanner sc = new Scanner(System.in);
		
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		int min, max;

		if (num1 < num2) {
			min = num1;
			max = num2;
		}else {
			min = num2;
			max = num1;
		}
		
		for (int i = min; i <= max; i++) {
			System.out.println(i);
		}
		
		sc.close();

	}

}
