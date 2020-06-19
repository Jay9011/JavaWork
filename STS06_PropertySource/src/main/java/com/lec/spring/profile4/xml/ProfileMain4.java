package com.lec.spring.profile4.xml;

import org.springframework.context.support.GenericXmlApplicationContext;

public class ProfileMain4 {

	public static void main(String[] args) {
		String config = "run";
		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext();
		
		/**
		 * 	xml 에 profile 을 세팅했기 때문에
		 * 	현재 활성화 할 profile 이 무엇인지 세팅해야 한다
		 */
		ctx.getEnvironment().setActiveProfiles(config);
		// profile 이 설정된 xml 을 불러온다. (그러면 setActiveProfiles 로 세팅된 xml profile 만 세팅된다)
		ctx.load("appCtx4_dev.xml", "appCtx4_run.xml");
		ctx.refresh();
		
		ServiceInfo info = ctx.getBean("serverInfo", ServiceInfo.class);
		System.out.println("ip : " + info.getIpNum());
		System.out.println("port : " + info.getPortNum());
		
		ctx.close();
	} // end main()
} // end Class
