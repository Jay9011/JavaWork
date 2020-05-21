package 디버깅1.형성평가3;

public class Main {
	/*
	 * 문제
	 * 아래의 프로그램을 작성하여 디버깅을 하면서 디버깅 창에서 ① 위치에서의 a의 값이 얼마인지 구하여 그 값을 출력하는 프로그램을 작성하시오.
	 *
	 * 입력형식
	 * 입력은 없습니다.
	 *
	 * 출력형식
	 * ①에서의 a값만 출력하는 프로그램을 작성하시오.
	 */
	public static void main(String[] args) {
		int a = 5;
		a+=10;
//		a = a - 1;
		System.out.printf("%d\n", a);
	}

}
