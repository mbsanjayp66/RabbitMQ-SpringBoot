package com.sanjay.rabbitmq.springBootrabbitMQ.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sanjay.rabbitmq.springBootrabbitMQ.DTO.User;
import com.sanjay.rabbitmq.springBootrabbitMQ.publisher.RabbitMQJsonProducer;

@RestController
@RequestMapping("/api/v1")
public class MessageJsonController {
	
	@Autowired
	RabbitMQJsonProducer rabbitMQJsonProducer;
	
	
	@PostMapping("/publish")
	ResponseEntity<String>sendMesaage(@RequestBody User usr){
		rabbitMQJsonProducer.sendJsonMsg(usr);
		return ResponseEntity.ok("Json Message Sent");
	}

}
