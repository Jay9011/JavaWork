package 연잔자.자가진단01;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		int n3 = sc.nextInt();
		
		System.out.printf("sum : %d\n", (n1 + n2 + n3));
		System.out.printf("avg : %d", (n1 + n2 + n3)/3);

		sc.close();
	}

}
