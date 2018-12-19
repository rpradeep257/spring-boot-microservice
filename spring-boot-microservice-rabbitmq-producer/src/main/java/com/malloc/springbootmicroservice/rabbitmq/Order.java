package com.malloc.springbootmicroservice.rabbitmq;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

public class Order implements Serializable {

    private static final long serialVersionUID = 2866410813438870990L;
    
    @Setter
    @Getter
    private String orderId;
    
    @Getter
    @Setter
    private LocalDateTime orderDateTime;
    
    public Order(String orderId, LocalDateTime orderDateTime) {
        this.orderId = orderId;
        this.orderDateTime = orderDateTime;
    }

    @Override
    public String toString() {
        return "Order [orderId=" + orderId + ", orderDateTime=" + orderDateTime + "]";
    }
}
