package fr.training.spring;


public class DependencyInjectionDeveloper {
	
	private Task task;
	
	public DependencyInjectionDeveloper(Task task) {
		this.task = task;
	}
	
	public void doTask() {
		task.execute();
	}
	
}
