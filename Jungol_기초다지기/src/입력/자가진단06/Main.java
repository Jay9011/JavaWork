package 입력.자가진단06;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("height = ");
		int h = sc.nextInt();
		
		System.out.printf("Your height is %dcm.", h);
		
		sc.close();
	}

}
