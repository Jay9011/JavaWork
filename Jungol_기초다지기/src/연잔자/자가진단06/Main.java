package 연잔자.자가진단06;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();

		System.out.printf("%d > %d --- %s\n", n1, n2, (n1 > n2));
		System.out.printf("%d < %d --- %s\n", n1, n2, (n1 < n2));
		System.out.printf("%d >= %d --- %s\n", n1, n2, (n1 >= n2));
		System.out.printf("%d <= %d --- %s\n", n1, n2, (n1 <= n2));

		sc.close();
	}

}
