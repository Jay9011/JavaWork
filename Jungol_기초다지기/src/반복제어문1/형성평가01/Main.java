package 반복제어문1.형성평가01;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		
		int count = 0;
		while (count < num) {
			count++;
			System.out.println(count);
		}
		
		sc.close();

	}

}
