package com.malloc.springbootmicroservice.rabbitmq;

import java.time.LocalDateTime;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class OrderMessageSender {
    
    Logger logger = LoggerFactory.getLogger(OrderMessageSender.class);
    
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Scheduled(fixedDelay = 11000)
    public void send() {
        
        Order order = new Order(UUID.randomUUID().toString(), LocalDateTime.now());
        
        logger.info("Sending order:{}", order);
        
        MessagePostProcessor messagePostProcessor = new MessagePostProcessor() {
            
            @Override
            public Message postProcessMessage(Message message) throws AmqpException {                
                logger.info("Messag ID: {}", message.getMessageProperties().getRedelivered());                
                return message;
            }
        };
        
        this.rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE_MALLOC, RabbitConfig.QUEUE_ORDERS, order);       
    }
}
