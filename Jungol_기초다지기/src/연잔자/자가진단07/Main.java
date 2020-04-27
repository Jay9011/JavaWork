package 연잔자.자가진단07;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		int a, b;
		boolean c, d;
		Scanner sc = new Scanner(System.in);
		
		a = sc.nextInt();
		b = sc.nextInt();
		
//		​hint : 정수 a를 입력받은 후 boolean c = (a != 0);을 실행하면 c에 a의 논리값이 저장된다.
		c = (a != 0);
		d = (b != 0);
		
		System.out.printf("%s %s", c&d, c|d);
		
		
		
		sc.close();
	}
}
