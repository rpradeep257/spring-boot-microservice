package com.malloc.springbootmicroservice.forexservice;


public interface ForexService {
    
    ExchangeValue retrieveExchangeValue (String from, String to);

}
