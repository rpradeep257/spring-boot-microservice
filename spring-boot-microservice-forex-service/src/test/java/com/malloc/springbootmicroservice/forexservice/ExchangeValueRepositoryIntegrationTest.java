package com.malloc.springbootmicroservice.forexservice;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ExchangeValueRepositoryIntegrationTest {
    
    @Autowired
    private TestEntityManager entityManager;
 
    @Autowired
    private ExchangeValueRepository exchangeValueRepository;

    @Test
    public void test() {
        
        ExchangeValue ev = new ExchangeValue();
        ev.setFrom("A");
        ev.setTo("B");
        ev.setConversionMultiple(BigDecimal.ONE);
        ev.setId(10005L);
        
        entityManager.persist(ev);
        entityManager.flush();
        
        exchangeValueRepository.save(ev);
       
        ExchangeValue e = exchangeValueRepository.findByFromAndTo("A", "B");
        
        assertEquals(BigDecimal.ONE, e.getConversionMultiple());
        
    }

}
