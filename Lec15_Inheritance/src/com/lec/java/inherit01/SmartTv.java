package com.lec.java.inherit01;

public class SmartTv {
	// 멤버 변수
	// 인스턴스 변수
	boolean isPowerOn;
	int channel;
	int volume;
	String ip;		// SmartTv 에서 새로 추가된 필드 
	
	// 메소드
	// 인스턴스 메소드
	public void displayInfo() {
		System.out.println("--- Smart TV 현재 상태 ---");
		System.out.println("전원: " + isPowerOn);
		System.out.println("채널: " + channel);
		System.out.println("볼륨: " + volume);
		System.out.println("IP주소 : " + ip);	// SmartTv 에서 추가된 코드
	}
	
}
