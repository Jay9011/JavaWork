package 연잔자.형성평가01;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int l = sc.nextInt();
		int e = sc.nextInt();
		int m = sc.nextInt();
		int c = sc.nextInt();

		System.out.printf("sum %d\navg %d", (l + e + m + c), (l + e + m + c) / 4);

		sc.close();
	}
}