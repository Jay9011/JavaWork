package com.lec.java.collection04;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Collection04Main {

	public static void main(String[] args) {
		System.out.println("ArrayList 연습");

		Scanner sc = new Scanner(System.in);
		ArrayList<MemberModel> members = new ArrayList<MemberModel>();
		
		for (int i = 0; i < 3; i++) {
			System.out.print("ID : ");
			String id = sc.next();
			System.out.print("PW : ");
			String pw = sc.next();
			System.out.println();
			members.add(new MemberModel(id, pw));
		}
		
		System.out.println("--- for ---");
		for (int i = 0; i < members.size(); i++) {
			members.get(i).displayInfo();
		}
		
		System.out.println("--- Enhanced For ---");
		for (MemberModel m : members) {
			m.displayInfo();
		}
		
		System.out.println("--- Iterator ---");
		Iterator<MemberModel> itrMem = members.iterator();
		while (itrMem.hasNext()) {
			itrMem.next().displayInfo();
		}
		
		sc.close();

		System.out.println("\n프로그램 종료");
	} // end main()

} // end class












