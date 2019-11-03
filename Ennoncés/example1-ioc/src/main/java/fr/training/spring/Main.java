package fr.training.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		Developer john = new Developer();
		john.doTask();
		
		DependencyInjectionDeveloper anna = new DependencyInjectionDeveloper(new ProgrammingTask());
		anna.doTask();
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		DependencyInjectionDeveloper sam = (DependencyInjectionDeveloper) ctx.getBean("springDeveloper");
		sam.doTask();
	}
}
