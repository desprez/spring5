package spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.bean.ToStringable;
import spring.bean.UserStringable;

public class Test4Stringable {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"spring/spring-config-4-stringable.xml");
		//
		// Interface : ToStringable and NOT the real instance : UserStringable
		//
		UserStringable toto = (UserStringable) context.getBean("totoImpl", UserStringable.class);
		
		ToStringable toto1 = (ToStringable) context.getBean("totoImpl", ToStringable.class);

		
		//ToStringable toto = context.getBean("toto", ToStringable.class);
		
		String str = toto.toString();
		System.out.println("The result is " + str);
		System.out.println("The second result is " + toto1.toString());
		context.close();
	}
}
