package spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.param.BeanParam;

public class Test9AnnotationsLiterauxEL {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-config-9-param.xml");
		//
		BeanParam bean = context.getBean(BeanParam.class);
		System.out.println(bean);
		//
		context.close();
	}
}
