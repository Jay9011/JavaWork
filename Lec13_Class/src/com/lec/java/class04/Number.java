package com.lec.java.class04;

public class Number {
	private int num = 100;	// 멤버변수 선언시 초기값 명시 가능

	// 디폴트 생성자
	public Number() {
		super();
	}

	// 매개변수 생성자
	public Number(int num) {
		super();
		this.num = num;
	}

	// getter & setter
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
	// 멤버 메소드
	public Number add(Number x) {
		this.num += x.num;
		return this;	// 자기 자신을 리턴
	}
	
	public Number sub(Number x) {
		this.num -= x.num;
		return this;	// 자기 자신을 리턴
	}
	
	// set 해야 할 멤버변수가 많~은 경우
	// setter 들을 메소드 체이닝

	private int num1;
	private int num2;
	private int num3;
	private int num4;
	private int num5;
	private int num6;

	public Number setNum1(int num1) {
		this.num1 = num1;
		return this;
	}

	public Number setNum2(int num2) {
		this.num2 = num2;
		return this;
	}

	public Number setNum3(int num3) {
		this.num3 = num3;
		return this;
	}

	public Number setNum4(int num4) {
		this.num4 = num4;
		return this;
	}

	public Number setNum5(int num5) {
		this.num5 = num5;
		return this;
	}

	public Number setNum6(int num6) {
		this.num6 = num6;
		return this;
	}
	
	
}
