package 연잔자.자가진단03;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n1 = sc.nextInt();
		
		System.out.printf("%d\n", n1++);
		System.out.printf("%d\n", ++n1);

		sc.close();
	}

}
