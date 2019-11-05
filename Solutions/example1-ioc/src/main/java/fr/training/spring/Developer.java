package fr.training.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Developer {

	@Autowired
	@Qualifier("documentingTask")
	private Task task;
	
	public Developer() {
	}
	
	public void doTask() {
		task.execute();
	}
	
}
