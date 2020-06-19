package com.lec.spring.scope;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.lec.spring.beans.Score;

public class ScopeMain {

	public static void main(String[] args) {
		System.out.println("Main 시작");

		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:appCtx02.xml");
		System.out.println("-- ctx 생성 --");
		
		Score score11 = ctx.getBean("score1", Score.class);
		Score score12 = ctx.getBean("score1", Score.class);
		System.out.println("====================");
		System.out.println(score11);
		System.out.println(score12);
		
		if(score11 == score12) {
			System.out.println("동일 인스턴스. 하나만 생겼네요?");
		} else {
			System.out.println("다른 인스턴스. 서로 다른 객체로 생겼나봐요.");
		}
		
		score12.setComment("score12의 코멘트를 바꿔봤는데 어때요?");
		System.out.println("====================");
		System.out.println(score11);
		System.out.println(score12);
		System.out.println("====================");

		
		// scope = "prototype"
		// getBean() 할 때 마다 새로운 Bean 인스턴스 생성
		
		Score score21 = ctx.getBean("score2", Score.class);
		Score score22 = ctx.getBean("score2", Score.class);
		System.out.println("====================");
		System.out.println(score21);
		System.out.println(score22);
		
		if(score21 == score22) {
			System.out.println("동일 인스턴스. 하나만 생겼네요?");
		} else {
			System.out.println("다른 인스턴스. 서로 다른 객체로 생겼나봐요.");
		}
		
		score22.setComment("score22의 코멘트를 바꿔봤는데 어때요?");
		System.out.println("====================");
		System.out.println(score21);
		System.out.println(score22);
		System.out.println("====================");

		ctx.close();
		System.out.println("Main 종료");
	} // end main()
} // end Class
