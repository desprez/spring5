package spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.qualifier.ServiceFacturation;

public class Test8Qualifier {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"spring/spring-config-8-qualifier.xml");
		//
		ServiceFacturation serv = context.getBean(ServiceFacturation.class);
		serv.faireMachin();
		//
		context.close();
	}
}
