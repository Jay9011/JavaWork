package com.lec.java.collection10;

import java.util.Iterator;
import java.util.TreeSet;

public class Collection10Main {

	public static void main(String[] args) {
		System.out.println("TreeSet 연습");
		
		// String 타입을 저장할 수 있는 TreeSet 인스턴스 생성
		// 5개 이상의 데이터를 저장해보고
		// 오름차순, 내림차순으로 출력해보기
		TreeSet<String> stringTree = new TreeSet<String>();
		
		stringTree.add("apple");
		stringTree.add("Home");
		stringTree.add("mouse");
		stringTree.add("Game");
		stringTree.add("tree");
		stringTree.add("tower");
		stringTree.add("village");
		
		System.out.println("오름차순");
		Iterator<String> itrString = stringTree.iterator();
		
		while (itrString.hasNext()) {
			System.out.println(itrString.next());
		}
		
		System.out.println();
		System.out.println();
		
		System.out.println("내림차순");
		Iterator<String> itrString2 = stringTree.descendingIterator();
		
		while (itrString2.hasNext()) {
			System.out.println(itrString2.next());
		}
		
		
		System.out.println("\n프로그램 종료");
	} // end main

} // end class

















