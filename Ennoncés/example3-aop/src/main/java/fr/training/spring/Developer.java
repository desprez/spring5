package fr.training.spring;

public class Developer {

	public void doTask(Task task) {
		task.execute();
	}

	public void takeABreak(long milliseconds) throws InterruptedException {
		Thread.sleep(milliseconds);
	}

}
