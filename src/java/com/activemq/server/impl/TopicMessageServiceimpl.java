package com.activemq.server.impl;

import java.beans.DesignMode;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import com.activemq.server.MessageService;

@Service
public class TopicMessageServiceimpl implements MessageService {

	@Autowired
	private JmsTemplate jmsTemplate;
	
	@Resource(name="topicDestination")
	private Destination destination;
	@Override
	public void sendMessage(final String msg) {
		
		jmsTemplate.send(destination, new MessageCreator() {
			
			@Override
			public Message createMessage(Session session) throws JMSException {
				// TODO Auto-generated method stub
				return session.createTextMessage(msg);
			}
		});
	}

}
