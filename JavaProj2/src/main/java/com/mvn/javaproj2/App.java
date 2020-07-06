package com.mvn.javaproj2;

/**
 * Hello world!
 *
 */
public class App {
	public String getWelcome() {
		return "Welcome";
	}
	
	public String getHello() {
		return "Hello";
	}
	
	public String getBye() {
		return "Bye";
	}
	
	public static void main(String[] args) {
		System.out.println("안녕하세요. JUnit");
		
		App app = new App();
		String welcome = app.getWelcome();
		String hello = app.getHello();
		String bye = app.getBye();
		
		// 위 메소드의 동작 과정을 검증하려면?
		if("Welcome".equals(welcome)) System.out.println(true);
		if("Hello".equals(hello)) System.out.println(true);
		if("Bye".equals(bye)) System.out.println(true);
	}
}
