package 연잔자.자가진단02;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n1 = sc.nextInt() + 100;
		int n2 = sc.nextInt() % 10;
		
		System.out.printf("%d %d\n", n1, n2);

		sc.close();
	}

}
