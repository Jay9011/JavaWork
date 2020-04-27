package com.lec.java.exception08;

// Exception 상속받은 예외 클래스 만들기
public class AgeInputException extends Exception{

	public AgeInputException() {
		super("유효하지 않은 나이입니다.");
	}
	
	public AgeInputException(String str) {
		super(str + "유효하지 않은 나이입니다.");
	}
} // end class AgeInputException
