package com.lec.java.inherit02;

// BasicTV
//	└─ SmartTv
public class SmartTv extends BasicTV{

	String ip;
	
	public void displayInfo() {
		super.displayInfo();
		System.out.println("IP 주소 : " + ip);
	}
}
