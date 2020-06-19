package com.lec.spring.lifecycle01;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.lec.spring.beans.Score;

public class LifeCycleMain01 {

	public static void main(String[] args) {
		System.out.println("Main 시작");
		/**
		 *  생성 + 설정
		 */
		// new GenericXmlApplicationContext(설정파일);	
		
		/**
		 *  생성 따로 
		 *  설정 따로
		 */
		// 먼저 컨테이너 생성
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();	// 생성
		System.out.println("컨테이너 생성 완료");
		
		// 나중에 설정을 load 할 수 있다.
		ctx.load("classpath:appCtx01_A.xml");
		System.out.println("설정 load 완료");
		
		// refresh() 해야 bean 생성까지 진행함.
		ctx.refresh();
		System.out.println("컨테이너 refresh 완료");
		
		// Bean 사용
		Score score1 = ctx.getBean("score1", Score.class);	// 사용
		System.out.println(score1);
		
		System.out.println("ctx 종료 직전");
		ctx.close();	// 종료
		System.out.println("Main 종료");
	} // end main()
} // end Class
