package practice;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main1 {
	
	public static void main(String[] args) {
		double num1;
		double num2;
		
		Scanner sc = new Scanner(System.in);
		
		try {
			num1 = sc.nextDouble();
			num2 = sc.nextDouble();
			
			System.out.printf("%.1f\n", num1 + num2);
			System.out.printf("%.1f\n", num1 * num2);
		} catch (InputMismatchException e) {
			System.out.println("숫자만 입력해 주세요.");
		} finally {
			sc.close();
		}
	}
}
