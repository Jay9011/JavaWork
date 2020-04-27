package 반복제어문1.형성평가03;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		/*
		 * 0 부터 100 까지의 점수를 계속 입력받다가 범위를 벗어나는 수가 입력되면 그 이전까지 입력된 자료의 합계와 평균을 출력하는 프로그램을
		 * 작성하시오.
		 * 
		 * (평균은 반올림하여 소수 첫째자리까지 출력한다.)
		 */

		Scanner sc = new Scanner(System.in);

		int sum = 0 , count = 0;
		double avg = 0.0;

		while (true) {
			int num = sc.nextInt();

			if ( num < 0 || 100 < num )
				break;

			sum += num;
			count++;
			
		} // end while
		avg = (double)sum / count;
		System.out.println("sum : " + sum);
		System.out.printf("avg : %.1f", avg);
		
	}

}
