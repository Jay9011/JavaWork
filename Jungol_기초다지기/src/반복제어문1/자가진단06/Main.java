package 반복제어문1.자가진단06;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		/*
		 * 문제
		 * 아래와 같이 나라 이름을 출력하고 숫자를 입력받아
		 * 해당하는 나라의 수도를 출력하는 작업을 반복하다가
		 * 해당하는 번호 이외의 숫자가 입력되면 "none"라고 출력한 후 종료하는 프로그램을 작성하시오.
		 * 
		 * 각 나라의 수도 :
		 * 대한민국 = 서울(Seoul)
		 * 미국 = 워싱턴(Washington)
		 * 일본 = 동경(Tokyo)
		 * 중국 = 북경(Beijing)
		 * 
		 * 입출력시 모양은 "입·출력예"와 같이 하시오.
		 * 
		 * 입·출력 예
		 * 1. Korea
		 * 2. USA
		 * 3. Japan
		 * 4. China
		 * number? 1
		 * 
		 * Seoul
		 * 
		 * 1. Korea
		 * 2. USA
		 * 3. Japan
		 * 4. China
		 * number? 5
		 * 
		 * none
		 * ​
		 */

		Scanner sc = new Scanner(System.in);
		int i = 0;
		while (true) {
			System.out.println("1. Korea");
			System.out.println("2. USA");
			System.out.println("3. Japan");
			System.out.println("4. China");
			System.out.print("number? "); 
			i = sc.nextInt();
			switch (i) {
			case 1:
				System.out.println();
				System.out.println("Seoul");
				break;
			case 2:
				System.out.println();
				System.out.println("Washington");
				break;
			case 3:
				System.out.println();
				System.out.println("Tokyo");
				break;
			case 4:
				System.out.println();
				System.out.println("Beijing");
				break;
			default:
				System.out.println();
				System.out.println("none");
				sc.close();
				return;
			}
			System.out.println();
		}
		
		
	}

}
