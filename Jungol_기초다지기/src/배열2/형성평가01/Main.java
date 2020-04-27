package 배열2.형성평가01;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		/*
		 * 문제
		 * 승지는 주사위 놀이를 하다가
		 * 주사위를 10번 던져서 각 숫자가 몇 번씩 나왔는지 알아보려고 한다.
		 * 한번 던질 때마다 나온 주사위의 숫자를 입력받아서
		 * 각 숫자가 몇 번씩 나왔는지 출력하는 프로그램을 작성하시오.
		 * 
		 * 입력 예
		 * 5 6 3 4 5 5 2 2 4 6
		 * 
		 * 출력 예
		 * 1 : 0
		 * 2 : 2
		 * 3 : 1
		 * 4 : 2
		 * 5 : 3
		 * 6 : 2
		 */
		
		Scanner sc = new Scanner(System.in);
		
		int[] num = new int[6];
		
		for (int i = 0; i < 10; i++) {
			int temp = sc.nextInt();	// temp 가 6이면 num[5]에 저장. (temp-1)
			num[temp-1]++;
			
		} // end for
		
		for (int i = 0; i < num.length; i++) {
			System.out.println((i + 1) + " : " + num[i]);
		}
		
		
		sc.close();

	}

}
