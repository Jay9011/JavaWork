package com.lec.java.inherit02;

public class BasicTV {
	// 멤버 변수
	private String name = "TV";
	boolean isPowerOn;
	int channel;
	int volume;
	
	// 메소드
	public void displayInfo() {
		System.out.println("--- " + name + " 현재 상태 ---");
		System.out.println("전원: " + isPowerOn);
		System.out.println("채널: " + channel);
		System.out.println("볼륨: " + volume);
	} // end displayInfo()
	
} // class BasicTV









