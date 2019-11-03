package spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.bean.User;

public class Test3 {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-config-3-0.xml");
		User toto = (User) context.getBean("toto");
		toto.setAge(25);
		String str = toto.toString();
		System.out.println("The result is " + str);

		User toto2 = (User) context.getBean("toto");
		// are toto and toto2 the same instance ?
		toto.setName("new toto mod");
		String str2 = toto2.toString();
		System.out.println("The result 2 is " + str2);
		context.close();
	}
}
