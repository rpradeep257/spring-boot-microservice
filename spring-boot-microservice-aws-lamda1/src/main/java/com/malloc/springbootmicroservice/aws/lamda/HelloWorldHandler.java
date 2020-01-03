package com.malloc.springbootmicroservice.aws.lamda;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

@Component
public class HelloWorldHandler implements RequestHandler<Object, String> {

    @Override
    public String handleRequest(Object input, Context context) {
        context.getLogger().log("Input: " + input);            
        LocalDateTime localDateTime = LocalDateTime.now();	
        
        return "Hello from Lambda - " + localDateTime;
    }

}
