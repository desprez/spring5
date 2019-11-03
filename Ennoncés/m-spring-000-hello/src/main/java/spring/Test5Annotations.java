package spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.annotations.ServiceMachin;
import spring.annotations.ServiceMachinImpl;

public class Test5Annotations {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"spring/spring-config-5-annotations.xml");
		ServiceMachin serv = (ServiceMachinImpl) context.getBean("serviceMachin");
		System.out.println("Mon paramètre = " + serv.getMonParametre());
		serv.faireMachin();
		context.close();
	}
}
