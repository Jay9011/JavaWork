package com.lec.java.oop03;

public class Car extends Vehicle{

	private int oil;

	public int getOil() {return oil;}

	public void setOil(int oil) {this.oil = oil;}
	
	@Override
	public void displayInfo() {
		System.out.println("--- Car 정보 ---");
		System.out.println("Speed : " + getSpeed());
		System.out.println("Oil : " + oil);
	}
	
	
}
