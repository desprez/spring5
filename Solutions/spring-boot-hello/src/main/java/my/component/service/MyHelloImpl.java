package my.component.service;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Badr
 */
public class MyHelloImpl implements MyHello {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public MyHelloImpl() {
		super();
		logger.debug("CREATED !!!!");
	}

	@PostConstruct
	public void init() {
		logger.debug("IN init ¤¤¤¤¤¤¤¤¤¤¤¤¤");
		this.sayHello("my friend");
	}

	@Override
	public String sayHello(String _message) {
		logger.debug("IN");
		String message = "Hello : " + _message;
		logger.info(message);
		return message;
	}

}
