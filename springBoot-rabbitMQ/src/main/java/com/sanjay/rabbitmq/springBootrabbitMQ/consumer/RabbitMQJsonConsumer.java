package com.sanjay.rabbitmq.springBootrabbitMQ.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.sanjay.rabbitmq.springBootrabbitMQ.DTO.User;

@Service
public class RabbitMQJsonConsumer {
	
	private final Logger logger = LoggerFactory.getLogger(RabbitMQJsonConsumer.class);
	
	@RabbitListener(queues = {"${rabbitmq.jsonQueue.name}"})
	public void consumeJsonListener(User usr) {
		logger.info(String.format("Received Json -> %s", usr.toString()));
	}

}
