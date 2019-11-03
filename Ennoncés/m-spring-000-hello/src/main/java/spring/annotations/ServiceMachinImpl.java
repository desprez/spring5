package spring.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("serviceMachin")
public class ServiceMachinImpl implements ServiceMachin {

	@Autowired
	private SousServiceTruc m_serviceTruc;
	private String m_monParametre = "default value";

	private ServiceMachinImpl() {
		System.out.println("ServiceMachin : on me construit!");
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
		System.out.println("travail dans le service Machin");
		m_serviceTruc.faireTruc();
	}
}
