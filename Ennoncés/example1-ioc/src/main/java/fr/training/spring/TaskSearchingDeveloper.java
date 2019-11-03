package fr.training.spring;

public class TaskSearchingDeveloper {
	
	public void doTask() {
		Task task = TeamLead.getTask();
		task.execute();
	}
	
	public static void main(String[] args) {
		TaskSearchingDeveloper lance = new TaskSearchingDeveloper();
		lance.doTask();
	}
}
