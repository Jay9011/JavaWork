package com.lec.java.collection08;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class Collection08Main {

	public static void main(String[] args) {
		System.out.println("HashSet 연습");
		Scanner sc = new Scanner(System.in);
		
		// MyClass 타입을 저장할 수 있는 HashSet 인스턴스 생성
		// 데이터 3개 이상 저장해보고 iterator, enhanced-for 등을 
		// 사용하여 출력해보기
		HashSet<MyClass> myClass = new HashSet<MyClass>();
		
		// 데이터 3개 저장
		for (int i = 0; i < 3; i++) {
			System.out.print("저장 할 학생의 이름 : ");
			myClass.add(new MyClass(i + 1, sc.next()));
			sc.nextLine();
		}
		
		// 검색: Iterator, enhanced for
		System.out.println();
		System.out.println("Iterator");
		Iterator<MyClass> itrClass = myClass.iterator();
		while (itrClass.hasNext()) {
			System.out.println(itrClass.next());
		} // while
		
		System.out.println();
		System.out.println("enhanced for");
		for (MyClass m : myClass) {
			System.out.println(m);
		} // for

		// forEach() 메소드 사용
		System.out.println();
		System.out.println("forEach() 사용");
		// TODO

		sc.close();
		System.out.println("\n프로그램 종료");
	} // end main()
} // end class

