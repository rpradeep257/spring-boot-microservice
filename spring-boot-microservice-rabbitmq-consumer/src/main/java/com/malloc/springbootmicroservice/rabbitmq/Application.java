package com.malloc.springbootmicroservice.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableDiscoveryClient
@EnableScheduling
public class Application {
    
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
    @Bean
    public Queue queueComplaints() {
        return new Queue("queue-complaints");
    }
    
    @Bean
    public Queue queueOrders() {
        return new Queue("queue-orders");
    }

    @RabbitListener(queues = {"queue-complaints"})
    public void process1(@Payload String message) {
        System.out.println("Received: " + message);
    }
    
    @RabbitListener(queues = {"queue-orders"})
    public void process2(@Payload String message) {
        System.out.println("Received: " + message);
    }
}
