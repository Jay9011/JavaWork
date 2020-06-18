package ex2_1;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class DIApp {
	public static void main(String[] args) {
		System.out.println("Main 시작");

		AbstractApplicationContext ctx =
				new GenericXmlApplicationContext("classpath:applicationContext.xml");
		System.out.println("--컨테이너 생성--");

		OperatorBean operator = null;
		operator = ctx.getBean("op", OperatorBean.class);
		int value = operator.doOperate();
		System.out.println(value);

		operator = ctx.getBean("op2", OperatorBean.class);
		value = operator.doOperate();
		System.out.println(value);

		System.out.println("Main 종료");
	}
}
