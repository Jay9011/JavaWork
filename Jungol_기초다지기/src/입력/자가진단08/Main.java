package 입력.자가진단08;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double i = sc.nextDouble();
		double j = sc.nextDouble();
		String s = sc.next();

		System.out.printf("%.2f\n", i);
		System.out.printf("%.2f\n", j);
		System.out.printf("%s", s);
		
		sc.close();
	}

}
