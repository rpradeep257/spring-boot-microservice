package com.malloc.springbootmicroservice.batch;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class OrderProducer {

	@Autowired
	private OrderRepository orderRepository;
	
	private AtomicLong atomicLong = new AtomicLong(1);
	
	@Scheduled(fixedRate = 1 * 30 * 1000)
	public void placeOrder() {
		
		long i = atomicLong.getAndIncrement();
		
		Order order = new Order();
		order.setId(i);
		order.setCustomerName("Customer-" + i);
		order.setOrderDate(java.sql.Timestamp.valueOf(LocalDateTime.now()));
		order.setNotified(false);
		order.setProcessed(false);
		order.setItem("item");
		order.setQuantity(10);
		
		orderRepository.save(order);
		
	}
	
}
