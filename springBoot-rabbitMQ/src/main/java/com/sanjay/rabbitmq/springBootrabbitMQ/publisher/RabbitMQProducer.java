package com.sanjay.rabbitmq.springBootrabbitMQ.publisher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQProducer {
	
	@Value("${rabbitmq.exchange.name}")
	private String exchange;
	
	@Value("${rabbitmq.routing.key}")
	private String routingKey;
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	private final Logger logger = LoggerFactory.getLogger(RabbitMQProducer.class);
	
	public void sendMessage(String message) {
		logger.info(String.format("Message Sent-> %s", message));
		rabbitTemplate.convertAndSend(exchange, routingKey, message);
	}
	

}
