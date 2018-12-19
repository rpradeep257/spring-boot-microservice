package com.malloc.springbootmicroservice.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
    
    public static final String QUEUE_COMPLAINTS = "queue-complaints";
    
    public static final String QUEUE_ORDERS = "queue-orders";
    
    public static final String EXCHANGE_MALLOC = "exchange-malloc";
    
    
    @Bean
    Exchange mainExchange() {
        return ExchangeBuilder.directExchange(EXCHANGE_MALLOC).build();
    }
    
    @Bean
    Queue ordersQueue() {
        return QueueBuilder.durable(QUEUE_ORDERS).build();
    }
    
    @Bean
    Queue complaintsQueue() {
        return QueueBuilder.durable(QUEUE_COMPLAINTS).build();
    }
    
    @Bean
    Binding binding1(Queue ordersQueue, DirectExchange mainExchange) {
        return BindingBuilder.bind(ordersQueue).to(mainExchange).with(QUEUE_ORDERS);
    }
    
    @Bean
    Binding binding2(Queue complaintsQueue, DirectExchange mainExchange) {
        return BindingBuilder.bind(complaintsQueue).to(mainExchange).with(QUEUE_COMPLAINTS);
    }
}
