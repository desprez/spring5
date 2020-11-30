package fr.training.spring;

public class DependencyInjectionDeveloper {

	private final Task task;

	public DependencyInjectionDeveloper(final Task task) {
		this.task = task;
	}

	public void doTask() {
		task.execute();
	}

}
