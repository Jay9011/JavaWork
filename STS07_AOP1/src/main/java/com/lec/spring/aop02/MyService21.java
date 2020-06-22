package com.lec.spring.aop02;

import com.lec.beans.Service;

public class MyService21 extends Service {

	@Override
	public void doAction() {
		// 공통기능이 없다?!
		
		printInfo();	// 핵심 기능

	} // end doAction()

	
	public void hahaha() {
		System.out.println("하하하");
	} // end hahaha()
} // end Class
