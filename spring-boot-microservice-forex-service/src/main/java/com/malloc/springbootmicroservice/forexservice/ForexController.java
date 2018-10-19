package com.malloc.springbootmicroservice.forexservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ForexController {
  
    @Autowired
    private ForexService forexService;
  
    //@GetMapping("currency-exchange/from/{from}/to/{to}")
    @RequestMapping(method = RequestMethod.GET, path = "currency-exchange/from/{from}/to/{to}")
    public ExchangeValue retrieveExchangeValue (@PathVariable String from, @PathVariable String to){
        ExchangeValue exchangeValue = forexService.retrieveExchangeValue(from, to);    
        return exchangeValue;
    }
}