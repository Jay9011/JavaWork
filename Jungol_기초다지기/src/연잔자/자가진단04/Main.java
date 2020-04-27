package 연잔자.자가진단04;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		
		int n3 = n1++ * --n2;
		
		System.out.printf("%d %d %d\n", n1, n2, n3);

		sc.close();
	}

}
