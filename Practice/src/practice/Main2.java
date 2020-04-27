package practice;

import java.util.Scanner;

public class Main2 {
	public static void main(String[] args) {
		String[] str = new String[3];
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < str.length; i++) {
			str[i] = sc.nextLine();
		}
		
		for (int i = 0; i < str.length; i++) {
			System.out.print(str[i].charAt(0));
		}
		
		sc.close();
		System.out.println("\n프로그램 종료");
	}
}
