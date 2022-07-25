package com.championship.config;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.championship.rabbitmq.Producer;


@Configuration
public class MachineAMQPConfig {

	@Value("${queue.name}")
	private String queueName;

	@Bean
	public Queue queue() {
		return new Queue(queueName);
	}

	// @Bean
	public Producer producer() {
		return new Producer();
	}
}