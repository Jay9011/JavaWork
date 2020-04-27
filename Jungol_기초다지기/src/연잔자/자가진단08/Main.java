package 연잔자.자가진단08;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		System.out.printf("%s %s",
				a > b ? (a > c ? true : false) : false,
				a == b ? (a == c ? true : false) : false
				);
		
		sc.close();
	}
}
