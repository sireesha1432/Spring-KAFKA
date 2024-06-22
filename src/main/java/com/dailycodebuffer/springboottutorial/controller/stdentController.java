package com.dailycodebuffer.springboottutorial.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dailycodebuffer.springboottutorial.student;

@RestController
public class stdentController {

	Logger logger = LoggerFactory.getLogger(stdentController.class);

	@Autowired
	KafkaTemplate<String, student> kafkaTemplate;

	@Value("${kafka.topic}")
	private String topic;

	@PostMapping("/ProduceStudent")
	public ResponseEntity<student> sendStudent(@RequestBody student s) {

		kafkaTemplate.send(topic, s);
		logger.info("rajesh", s);
		return ResponseEntity.ok(s);

		// return null;

	}

}
