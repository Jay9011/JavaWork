package 반복제어문2.형성평가03;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// 정수를 입력받아서 1부터 입력받은 정수까지의 5의 배수의 합을 구하여 출력하는 프로그램을 작성하시오.
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int sum = 0;
		
		for (int i = 1; i <= num; i++) {
			if(i % 5 == 0) sum +=i;
		}
		System.out.println(sum);
		
		sc.close();
	}

}
