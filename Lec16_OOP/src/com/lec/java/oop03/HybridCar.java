package com.lec.java.oop03;

public class HybridCar extends Car {

	private int electricity;

	public int getElectricity() {return electricity;}

	public void setElectricity(int electricity) {this.electricity = electricity;}
	
	@Override
	public void displayInfo() {
		System.out.println("--- HybridCar 정보 ---");
		System.out.println("Speed : " + getSpeed());
		System.out.println("Oil : " + getOil());
		System.out.println("Electricity : " + electricity);
	}
	
	
}
