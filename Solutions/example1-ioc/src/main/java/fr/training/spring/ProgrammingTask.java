package fr.training.spring;

import org.springframework.stereotype.Component;

@Component
public class ProgrammingTask implements Task {

	public void execute() {
		System.out.println("programming...");
	}

}
