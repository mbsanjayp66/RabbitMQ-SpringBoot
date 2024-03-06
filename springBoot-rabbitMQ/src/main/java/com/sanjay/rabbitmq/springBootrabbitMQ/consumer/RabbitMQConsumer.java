package com.sanjay.rabbitmq.springBootrabbitMQ.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
public class RabbitMQConsumer {
	
	private final Logger logger = LoggerFactory.getLogger(RabbitMQConsumer.class);
	
	@RabbitListener(queues = {"${rabbitmq.queue.name}"})
	public void consume(String message) {
		logger.info(String.format("Message Received-> %s", message));
	}
	
	
}
