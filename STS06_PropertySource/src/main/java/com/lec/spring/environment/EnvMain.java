package com.lec.spring.environment;

import java.io.IOException;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.io.support.ResourcePropertySource;

public class EnvMain {

	public static void main(String[] args) {
		System.out.println("Main 시작");
		
		/**
		 * 	Context -> Environment -> PropertySources
		 */
		ConfigurableApplicationContext ctx =
				new GenericXmlApplicationContext();
		ConfigurableEnvironment env = ctx.getEnvironment();	// <- ConfigurableApplicationContext 메서드임.
		MutablePropertySources propertySources = env.getPropertySources();
		
		// PropertySources 에 PropertySource 추가
		try {
			// PropertySource 하나를 생성하여 PropertySources 에 추가 : addLast() <-- 끝에 추가
			propertySources.addLast(
					new ResourcePropertySource("classpath:admin.auth")	// IOException
					);
			
			// 이제, Environment 를 통해 원하는 property 에 접근 가능
			// 굳이 '어느 PropertySource' 의 '어느 property' 를 접근할지 지정할 필요가 없다.
			// '어느 property' 에 대한 것만 요청하면
			// PropertySources 에 소속된 모~든 PropertySource 들을 다 스캔해서 찾아낸다!
			System.out.println(env.getProperty("admin.id"));
			System.out.println(env.getProperty("admin.pw"));
			
		} catch (IOException e) {
			e.printStackTrace();
		} // end try
		
		GenericXmlApplicationContext gCtx = (GenericXmlApplicationContext) ctx;
		gCtx.load("classpath:appCtx1.xml");	// 설정 로딩
		gCtx.refresh();	// Bean 생성
		
		AdminConnection adminConnection = gCtx.getBean("adminConnection", AdminConnection.class);
		
		System.out.println("admin ID : " + adminConnection.getAdminId());
		System.out.println("admin PW : " + adminConnection.getAdminPw());
		
		gCtx.close();
		System.out.println("Main 종료");
	} // end main()
} // end Class
