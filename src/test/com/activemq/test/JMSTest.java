package com.activemq.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.activemq.server.MessageService;
import com.activemq.server.impl.MessageServiceImpl;
import com.activemq.server.impl.TopicMessageServiceimpl;

public class JMSTest {

	private ApplicationContext context = new FileSystemXmlApplicationContext(new String[]{"classpath:spring-*.xml"});
	
	//@Test
	public void Test(){
		MessageService service = context.getBean(MessageServiceImpl.class);
		service.sendMessage("queueMsg come in");
	}
	@Test
	public void Test2(){
		MessageService service = context.getBean(TopicMessageServiceimpl.class);
		service.sendMessage("topicMsg come in");
	}
}
