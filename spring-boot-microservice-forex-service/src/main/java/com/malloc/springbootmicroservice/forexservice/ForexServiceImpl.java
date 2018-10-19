package com.malloc.springbootmicroservice.forexservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ForexServiceImpl implements ForexService {

    @Autowired
    private ExchangeValueRepository repository;
  
    public ExchangeValue retrieveExchangeValue (String from, String to){
        ExchangeValue exchangeValue = repository.findByFromAndTo(from, to);    
        return exchangeValue;
    }

}
