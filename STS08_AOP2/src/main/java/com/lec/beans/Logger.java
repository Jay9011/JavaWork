package com.lec.beans;

/**
 *  log in / log out 동작과 같은
 * 	공통기능 / 관심기능 (concern) 이 담긴 객체
 * 
 *	나중에 Advice 로 사용되는 코드
 * 
 */

public class Logger {

	public void LogIn() {
		System.out.println("## 로그인 처리 ##");
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} // end try-catch
		
	} // end LogIn()
	
	public void LogOut() {
		System.out.println("## 로그아웃 처리 ##");
		
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} // end try-catch

	} // end LogOut()
	
	public void logAdvice() {
		System.out.print("[Advice] ");
	}
	
} // end Class
