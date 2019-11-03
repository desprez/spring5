package spring.qualifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ServiceFacturationImpl implements ServiceFacturation {

	@Autowired
	@Qualifier("s1")
	private ServicePersonnel servicePersonnel;
	private String m_monParametre = "default value";

	public ServiceFacturationImpl() {
		System.out.println("ServiceFacturation : on me construit!");
	}

	@Override
	public String getMonParametre() {
		return m_monParametre;
	}

	public void setMonParametre(String _monParametre) {
		m_monParametre = _monParametre;
	}

	@Override
	public void faireMachin() {
		System.out.println("travail dans le ServiceFacturation");
		servicePersonnel.fairePersonnel();
	}
}
