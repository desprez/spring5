package my.component.service.starter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

	@Bean
	StarterHello myHello() {
		return new StarterHelloImpl();
	}

}
