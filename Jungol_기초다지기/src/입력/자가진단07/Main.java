package 입력.자가진단07;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i = sc.nextInt();
		int j = sc.nextInt();

		System.out.printf("%d * %d = %d\n", i, j, (i * j));
		System.out.printf("%d / %d = %d", i, j, (i / j));

		sc.close();
	}

}
