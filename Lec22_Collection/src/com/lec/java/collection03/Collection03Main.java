package com.lec.java.collection03;

import java.util.ArrayList;
import java.util.Scanner;

public class Collection03Main {

	public static void main(String[] args) {
		System.out.println("ArrayList 연습");
		
		// Student 타입을 담는 ArrayList를 만드고
		// 사용자로부터 3개의 Student 데이터 을 입력받아서
		//			(id, name, kor, eng, math)
		// 3가지 방법으로 출력해보세요. 
		// for, Enhanced-for, Iterator
		
		Scanner sc = new Scanner(System.in);
		ArrayList<Student> stuSco = new ArrayList<Student>();
		
		for (int i = 0; i < 3; i++) {
			System.out.print("학생의 번호 : ");
			int id = sc.nextInt();
			System.out.print("　　　 이름 : ");
			String name = sc.next();
			System.out.print("　국어 점수 : ");
			int kor = sc.nextInt();
			System.out.print("　영어 점수 : ");
			int eng = sc.nextInt();
			System.out.print("　수학 점수 : ");
			int math = sc.nextInt();
			
			stuSco.add(new Student(id, name, new Score(kor, eng, math)));
			
			
		}
		
		for (Student s : stuSco) {
			System.out.println(s);
		}
		

		
		sc.close();
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class









