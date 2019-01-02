package com.malloc.springbootmicroservice.alexa;

import javax.ws.rs.core.MediaType;

import org.joda.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class AlexaController {
    
    @Autowired
    private HelloWorldSkillServlet helloWorldSkillServlet;
	
    @RequestMapping(method = RequestMethod.GET)
    public String retrieveExchangeValue (){
       System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
       return "AAAAAAAAAAAAA " + new LocalDateTime();
    }
}
