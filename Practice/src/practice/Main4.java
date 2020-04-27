package practice;

import java.util.Scanner;

public class Main4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int max = 0;
		int min = Integer.MAX_VALUE;
		while (true) {
			int num = sc.nextInt();
			if (num == 0) {
				break;
			}
			if (max < num) {
				max = num;
			}
			if (min > num) {
				min = num;
			}
			
		}
		System.out.println(max + " " + min);
		sc.close();
		System.out.println("\n프로그램 종료");
	}
}
