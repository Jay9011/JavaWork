package com.lec.java.class03;

public class Numeric {
	// 멤버 변수
	private char ch;
	private byte operator;
	private int operand1;
	private int operand2;
	
	// 기본 생성자
	public Numeric() {
	}

	
	// 매개변수 있는 생성자
	public Numeric(char ch, byte operator) {
		this.ch = ch;
		this.operator = operator;
	}

	public Numeric(char ch, byte operator, int operand1) {
		this.ch = ch;
		this.operator = operator;
		this.operand1 = operand1;
	}
	
	public Numeric(char ch, byte operator, int operand1, int operand2) {
		this.ch = ch;
		this.operator = operator;
		this.operand1 = operand1;
		this.operand2 = operand2;
	}

	
	// getter & setter
	public char getCh() {
		return this.ch;
	}
	
	public void setCh(char ch) {
		this.ch = ch;
	}
	
	public byte getOperator() {
		return this.operator;
	}
	
	public void setOperator(byte operator) {
		this.operator = operator;
	}
	
	public int getOperand1() {
		return this.operand1;
	}
	
	public void setOperand1(int operand1) {
		this.operand1 = operand1;
	}
	
	public int getOperand2() {
		return this.operand2;
	}
	
	public void setOperand2(int operand2) {
		this.operand2 = operand2;
	}
}
