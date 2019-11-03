package spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.annotations.ServiceMachin;

public class Test6AnnotationsLiteraux {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"spring/spring-config-6-annotations.xml");
		//
		ServiceMachin serv = (ServiceMachin) context.getBean("serviceMachin");
		System.out.println("Mon paramètre = " + serv.getMonParametre());
		serv.faireMachin();
		//
		ServiceMachin serv2 = (ServiceMachin) context.getBean("serviceMachin2");
		System.out.println("Mon paramètre = " + serv2.getMonParametre());
		serv2.faireMachin();
		//
		context.close();
	}
}
