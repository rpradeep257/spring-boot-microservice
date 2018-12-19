package com.malloc.springbootmicroservice.rabbitmq;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ComplaintMessageSender {
    
    Logger logger = LoggerFactory.getLogger(ComplaintMessageSender.class);
    
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Scheduled(fixedDelay = 10000)
    public void send() {
        logger.info("Sending complaint...");        
        this.rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE_MALLOC, RabbitConfig.QUEUE_COMPLAINTS, new Date());        
    }
}
