package practice;

import java.util.Scanner;

public class Main3 {
	public static void main(String[] args) {
		String[] days = {"일요일","월요일","화요일","수요일","목요일","금요일","토요일"};
		int select = 0;
		Scanner sc = new Scanner(System.in);
		select = sc.nextInt();
		
		if(select < 0 || select > 7) {
			System.out.println("잘못 입력하셨습니다.");
		} else {
			System.out.println(days[select]);
		}
		
		sc.close();
		System.out.println("\n프로그램 종료");
	}
}
