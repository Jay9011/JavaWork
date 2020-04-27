package 입력.자가진단09;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double i = sc.nextDouble();
		double j = sc.nextDouble();
		double s = sc.nextDouble();

		System.out.printf("%.3f\n", i);
		System.out.printf("%.3f\n", j);
		System.out.printf("%.3f", s);
		
		sc.close();
	}

}
