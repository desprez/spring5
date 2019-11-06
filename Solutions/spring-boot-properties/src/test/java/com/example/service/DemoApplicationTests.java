package com.example.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.DemoApplicationTest;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DemoApplicationTest.class)
public class DemoApplicationTests {

	@MockBean
	private HelloProperties helloProperties;

	@Autowired
	private HelloService helloService;

	@Test
	public void contextLoads() {
		when(helloProperties.getMessage()).thenReturn("TestMe");
		String result = helloService.sayHello("Badr");
		assertNotNull(result);
		assertEquals("TestMeBadr", result);
	}

}
