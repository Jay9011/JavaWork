package com.lec.java.inherit07;

// Person 을 fianl 로 선언하면 상속이 불가능해진다.
// cannot subclass the final class
public class BusinessPerson extends Person {
	private String compony;

	public String getCompony() {
		return compony;
	}

	public void setCompony(String compony) {
		this.compony = compony;
	}
	
	// 메소드 재정의 (Overriding)
	@Override	// annotation (어노테이션)
	public void showInfo() {
		super.showInfo();
		System.out.println("회사 : " + compony);
	}
//	public void showInfo() {
//		super.showInfo();
//		System.out.println("회사 : " + compony);
//	}

	// 이클립스 단축키
	// ALT + SHIFT + S, V
	
	// final 로 선언된 메소드는 Overriding 할 수 없다
//	@Override
//	public void whoAreYou() {	// override the final method
//		super.whoAreYou();
//	}
	
	@Override
	public String toString() {
		return "BusinessPerson: " + getName() + " " + compony;
	}

	// 매소드 오버로딩 (Overloading)
	public void showInfo(int id) {
		System.out.println("id = " + id);
		showInfo();
	}
}
