package 입력.형성평가04;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i = sc.nextInt();
		int j = sc.nextInt();
		int s = sc.nextInt();

		System.out.printf("sum = %d\n", i + j + s);
		System.out.printf("avg = %d\n", (i + j + s)/3);
		
		sc.close();
	}

}
