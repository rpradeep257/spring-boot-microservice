package com.malloc.springbootmicroservice.forexservice;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.reactive.server.WebTestClient.ResponseSpec;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
public class ForexControllerIntegrationTest {
    
    @LocalServerPort
    private int port;
    
    @Autowired
    private WebTestClient webClient;
    
    @Autowired
    private ForexController controller;
    
    @Test
    public void contexLoads() throws Exception {
        assertNotNull(controller);
    }
    
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    @Ignore
    public void greetingShouldReturnDefaultMessage() throws Exception {
        String response = this.restTemplate.getForObject("http://localhost:" + port + "/currency-exchange/from/GBP/to/INR", String.class);
        System.out.println(response);
        assertEquals(response, "{\"id\":10004,\"from\":\"INR\",\"to\":\"GBP\",\"conversionMultiple\":0.09}");
    }
    
    @Test
    public void test() {
        
        ResponseSpec s = this.webClient.get().uri("/currency-exchange/from/GBP/to/INR").exchange();
        s.expectStatus().isOk()            
            .expectBody().equals("{\"id\":10004,\"from\":\"INR\",\"to\":\"GBP\",\"conversionMultiple\":0.09}");
        
    }

}
