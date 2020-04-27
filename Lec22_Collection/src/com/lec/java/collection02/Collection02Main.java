package com.lec.java.collection02;

import java.util.ArrayList;
import java.util.Iterator;

public class Collection02Main {

	public static void main(String[] args) {
		System.out.println("ArrayList 연습");
		// String 타입을 담는 ArrayList를 만들고
		// 5개 이상의 String을 저장하고
		// set(), remove() 등의 메소드 사용하여
		// 임의의 것을 수정, 삭제 도 해보시고
		// 3가지 방식으로 출력해보세요
		//  for, Enhanced-for, Iterator
		
		ArrayList<String> strings = new ArrayList<String>();
		
		strings.add("1번째 문자열");
		strings.add("2번째 문자열");
		strings.add("3번째 문자열");
		strings.add("4번째 문자열");
		strings.add("5번째 문자열");
		
		strings.set(2, "변경된 3번째 문자열");
		
		strings.remove(3);
		
		System.out.println("for 문으로 출력");
		for (int i = 0; i < strings.size(); i++) {
			System.out.println(strings.get(i));
		}
		System.out.println();
		
		System.out.println("Enhanced-for 문으로 출력");
		for (String s : strings) {
			System.out.println(s);
		}
		System.out.println();
		
		System.out.println("Iterator 로 출력");
		Iterator<String> itrStrings = strings.iterator();
		while(itrStrings.hasNext()) {
			System.out.println(itrStrings.next());
		}
		System.out.println();

		
		
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class












