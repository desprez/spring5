package fr.training.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(final String[] args) {

		final ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		final Developer sam = (Developer) ctx.getBean("developer");
		sam.doTask();
	}
}
