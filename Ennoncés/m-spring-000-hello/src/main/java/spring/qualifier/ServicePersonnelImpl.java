package spring.qualifier;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("s1")
public class ServicePersonnelImpl implements ServicePersonnel {

	public ServicePersonnelImpl() {
		System.out.println("ServicePersonnel : on me construit!");
	}

	@Override
	public void fairePersonnel() {
		System.out.println("travail dans le service fairePersonnel");
	}
}
