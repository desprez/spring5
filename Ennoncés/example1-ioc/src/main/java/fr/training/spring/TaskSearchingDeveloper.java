package fr.training.spring;

public class TaskSearchingDeveloper {

	public void doTask() {
		final Task task = TeamLead.getTask();
		task.execute();
	}

	public static void main(final String[] args) {
		final TaskSearchingDeveloper lance = new TaskSearchingDeveloper();
		lance.doTask();
	}
}
