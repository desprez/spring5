package spring.qualifier;

import org.springframework.stereotype.Component;

@Component
// @Qualifier("s2")
public class ServicePersonnel2Impl implements ServicePersonnel {

	public ServicePersonnel2Impl() {
		System.out.println("ServicePersonnel2 : on me construit!");
	}

	@Override
	public void fairePersonnel() {
		System.out.println("travail dans le service fairePersonnel");
	}
}
