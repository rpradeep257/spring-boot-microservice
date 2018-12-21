package com.malloc.springbootmicroservice.alexa;

import org.joda.time.LocalDateTime;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class AlexaController {
	
	  
    //@GetMapping("currency-exchange/from/{from}/to/{to}")
    @RequestMapping(method = RequestMethod.GET)
    public String retrieveExchangeValue (){
       System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
       return "AAAAAAAAAAAAA " + new LocalDateTime();
    }
    
    
    
}
