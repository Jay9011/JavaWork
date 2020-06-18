package com.lec.spring.di02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.lec.spring.MessageBean;

public class DIMain02 {

	public static void main(String[] args) {
		/**
		 *	Dependency Injection (DI, 의존주입)
		 *	필요한 객체는 누가 만들어 사용하나?
		 *
		 *	방법2 : 외부에서 만들어 주입 (injection)
		 *	스프링 특징 의존주입 (Dependenty Injection) 사용
		 *	즉 '외부' 에서 만들어 놓은 것을 가져옴.
		 */
		System.out.println("Main 시작");

		// Spring 설정파일 resource 명시
		String configLocation = "classpath:appCtx.xml";

		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation);
		System.out.println("Application Context 컨테이너 생성 완료\n");

		// 외부에서 만들어진 객체 주입 (injection)
		MessageBean msg = ctx.getBean("messageBean", MessageBean.class);
									// ↑ bean 의 id 값		↑ bean 의 타입

		msg.sayHello();

		System.out.println("Main 종료");

	}

}
