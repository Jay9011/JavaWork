package 디버깅1.형성평가4;

import java.util.Calendar;

public class Main {
	/*
	 * 문제
	 * 다음의 프로그램을 작성하고 디버깅을 하며 ①, ②, ③ 위치의 값을 watches에서 a의 값을 출력하시오.
	 *
	 * 즉, ​①에서 a의 값, ②에서 a의 값, ③에서 a의 값을 1,2,3과 바꾸어 출력하면 됩니다.
	 * (PC의 시간이 맞는지 확인하세요. 시간이 다르면 결과가 틀릴 수 있습니다.)
	 *
	 * 입력형식
	 * ① ② ③ 의 값만 출력
	 */
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();

		int a = 0;
		a = cal.get(Calendar.YEAR) - 1900; // ---①
		int temp1 = a;
		a += cal.get(Calendar.MONTH); // ---②
		int temp2 = a;
		a += cal.get(Calendar.DATE);
		int temp3 = a;
		System.out.printf("%d %d %d ", temp1, temp2, temp3); // ---③
		// ① ② ③에서의 a값을 1, 2, 3자리에 각각 써 넣는다.
	}

}
