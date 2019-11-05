package com.example.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class HelloServiceImpl implements HelloService {

	private static final Logger LOG = LoggerFactory.getLogger(HelloServiceImpl.class);

	@Autowired
	private HelloProperties helloProperties;

	@Value("${hello.message}")
	private String prop;

	@Override
	public String sayHello(String _msg) {
		LOG.info(helloProperties.getMessage() + _msg);
		LOG.info(prop);
		return helloProperties.getMessage() + _msg;
	}

}
