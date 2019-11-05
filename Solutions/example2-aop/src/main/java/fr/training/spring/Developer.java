package fr.training.spring;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Developer {
	 
	private static final Log LOGGER = LogFactory.getLog(Developer.class);
	
	public void doTask(Task task) {
		// LOGGER.info("calling 'doTask' with argument: " + task);
		task.execute();
	}
	
	public void takeABreak(long milliseconds) throws InterruptedException {
		// LOGGER.info("calling 'takeABreak' with argument: " + milliseconds);
		Thread.sleep(milliseconds);
	}
	
}
