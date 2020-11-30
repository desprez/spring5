package fr.training.spring;

import org.springframework.stereotype.Component;

@Component
public class DocumentingTask implements Task {

	@Override
	public void execute() {
		System.out.println("writing documentation...");
	}

}
