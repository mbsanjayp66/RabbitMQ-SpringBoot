package com.sanjay.rabbitmq.springBootrabbitMQ.publisher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.sanjay.rabbitmq.springBootrabbitMQ.DTO.User;

@Service
public class RabbitMQJsonProducer {
	
	@Value("${rabbitmq.exchange.name}")
	private String exchange;
	
	@Value("${rabbitmq.routing.json.key}")
	private String routingJsonKey;
	
	@Autowired
	RabbitTemplate rabbitTemplate;
	
	private final Logger logger = LoggerFactory.getLogger(RabbitMQJsonProducer.class);
	
	public void sendJsonMsg(User usr) {
		logger.info(String.format("Send Message-> %s", usr.toString()));
		rabbitTemplate.convertAndSend(exchange, routingJsonKey, usr);
	}
}
