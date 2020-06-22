package com.lec.spring.aop03;

import com.lec.beans.ServiceEx;

public class MyServiceEx32 extends ServiceEx {

	@Override
	public void doWorking() {
		printInfo();
	} // end doWorking()

	@Override
	public void quitAction() {
		printInfo();
	} // end quitAction()

	@Override
	public void doAction() {
		printInfo();
	} // end doAction()

} // end Class
