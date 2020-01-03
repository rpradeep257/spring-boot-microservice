package com.malloc.springbootmicroservice.aws.sqs;

import java.util.Map.Entry;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.sqs.*;
import com.amazonaws.services.sqs.model.DeleteMessageRequest;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;
import com.amazonaws.services.sqs.model.ReceiveMessageResult;

@Component
public class MessageReceiver {
	
	final AmazonSQS sqs = AmazonSQSClientBuilder.standard()
			.withRegion(Regions.EU_WEST_2)			
			.build();
	
	final String queueUrl = sqs.getQueueUrl("myQueue.fifo").getQueueUrl();
	
	@Scheduled(fixedRate = 1 * 60 * 1000, initialDelay = 60 * 1000)
	public void sendMessage() {
		ReceiveMessageRequest receiveMessageRequest = new ReceiveMessageRequest(queueUrl);
		receiveMessageRequest.setMaxNumberOfMessages(1);
		
		ReceiveMessageResult result = sqs.receiveMessage(receiveMessageRequest);
		
		for (final Message message : result.getMessages()) {
		    System.out.println("Message");
		    System.out.println("  MessageId:     " + message.getMessageId());
		    System.out.println("  ReceiptHandle: " + message.getReceiptHandle());
		    System.out.println("  MD5OfBody:     " + message.getMD5OfBody());
		    System.out.println("  Body:          " + message.getBody());
		    for (final Entry<String, String> entry : message.getAttributes().entrySet()) {
		        System.out.println("Attribute");
		        System.out.println("  Name:  " + entry.getKey());
		        System.out.println("  Value: " + entry.getValue());
		    }
		    
		    final String messageReceiptHandle = message.getReceiptHandle();
		    sqs.deleteMessage(new DeleteMessageRequest(queueUrl, messageReceiptHandle));
		}
		System.out.println();
		
		
	}

}
