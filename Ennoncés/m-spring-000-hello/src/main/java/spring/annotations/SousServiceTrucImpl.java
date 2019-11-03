package spring.annotations;

import org.springframework.stereotype.Component;

@Component
public class SousServiceTrucImpl implements SousServiceTruc {

	private SousServiceTrucImpl() {
		System.out.println("SousServiceTruc : on me construit!");
	}

	@Override
	public void faireTruc() {
		System.out.println("travail dans le service Truc");
	}
}
