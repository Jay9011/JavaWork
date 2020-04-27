package 연잔자.형성평가02;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int l = sc.nextInt();
		int e = sc.nextInt();

		System.out.printf("%d / %d = %d...%d", l, e, (l/e), (l%e));

		sc.close();
	}
}