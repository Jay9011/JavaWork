package com.lec.java.wrapper02;

/* Java 5부터 wrapper 클래스의 auto-boxing/unboxing 기능 제공
 * 	boxing(포장): 기본자료형의 값을 wrapper 클래스에 저장하는 것
 * 	unboxing(개봉): wrapper 클래스에 저장된 기본자료형 값을 꺼내는 것
 */
public class Wrapper02Main {

	public static void main(String[] args) {
		System.out.println("auto-boxing, auto-unboxing");

		Integer num1 = 10;	// Integer.valueOf(10);	// Auto-boxing
		Integer num2 = 20;
		System.out.println(num1 + num2); 			// Auto-unBoxing
		// 위의 연산은 내부적으로 아래와 같이 작동한다.
		System.out.println(num1.intValue() + num2.intValue());	// Interger.intValur()	// unBoxing
		
		Integer num3 = num1 + num2;
		Integer num30 = Integer.valueOf(num1.intValue() + num2.intValue());
		// 두 동작의 결과가 같다.	(Auto-unBoxing 한 int 를 연산 후 valueOf()로 Auto-Boxing 을 수행한 뒤 Integer 에 넣는다)

		
		System.out.println();
		System.out.println("boxing/unboxing");
		// boxing(포장): 기본자료형의 값을 wrapper 클래스에 저장하는 것
		// unboxing(개봉): wrapper 클래스에 저장된 기본자료형 값을 꺼내는 것
		Integer num4 = Integer.valueOf(100);	// Boxing
		num4.intValue();						// unBoxing
		
		
		System.out.println();
		System.out.println("auto-boxing/auto-unboxing");

		// TODO
		
		System.out.println();
		System.out.println("wrapper 클래스들");
		// 나머지 8개의 Wrapper Class도 같은 동작을 한다.
		// Byte, Short, Integer, Long, Float, Double, Character, Boolean
		Long num100 = Long.valueOf(1000000000000000000L);
		Long num101 = 1000000000000000001L;
		
		Double num200 = 3.14;
		
		System.out.println(num1.intValue());
		System.out.println(num1.doubleValue());	// unBoxing 은 원하는 타입으로 가능
		
		
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class















