package com.malloc.springbootmicroservice.aws.sqs;

import java.time.LocalDateTime;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.sqs.*;
import com.amazonaws.services.sqs.model.SendMessageRequest;

@Component
public class MessageSender {
	
	final AmazonSQS sqs = AmazonSQSClientBuilder.standard()
			.withRegion(Regions.EU_WEST_2)			
			.build();
	
	final String queueUrl = sqs.getQueueUrl("myQueue.fifo").getQueueUrl();
	
	@Scheduled(fixedRate = 5 * 60 * 1000, initialDelay = 60 * 1000)
	public void sendMessage() {
		LocalDateTime dateTime = LocalDateTime.now();
		SendMessageRequest sendMessageRequest = new SendMessageRequest(queueUrl, "Hello World " + dateTime);
		sendMessageRequest.setMessageGroupId("helloWorldGroup");
		
		sqs.sendMessage(sendMessageRequest);
	}

}
