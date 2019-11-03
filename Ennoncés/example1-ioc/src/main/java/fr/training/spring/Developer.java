package fr.training.spring;

public class Developer {

	private Task task;
	
	public Developer() {
		task = new ProgrammingTask();
	}
	
	public void doTask() {
		task.execute();
	}
	
}
