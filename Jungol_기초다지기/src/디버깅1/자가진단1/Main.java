package 디버깅1.자가진단1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 두 실수를 입력 받는다.
		double n1 = sc.nextDouble();
		double n2 = sc.nextDouble();

		int r1 = (int) (n1 * n2);	// 두 실수의 곱의 결과에 (int) 로 형변환한다.
		int r2 = (int) n1 * (int) n2;	// 두 실수를 정수로 형변환 한 후 곱한다.

		System.out.printf("%d %d", r1, r2);	// 각 정수 결과를 출력한다.

		sc.close();
	}

}
