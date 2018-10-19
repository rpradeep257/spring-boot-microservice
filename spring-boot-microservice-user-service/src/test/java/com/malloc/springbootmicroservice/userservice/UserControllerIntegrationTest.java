package com.malloc.springbootmicroservice.userservice;


import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.malloc.springbootmicroservice.userservice.UserController;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
public class UserControllerIntegrationTest {
    
    @LocalServerPort
    private int port;
    
    @Autowired
    private WebTestClient webClient;
    
    @Autowired
    private UserController controller;
    
    @Test
    public void contexLoads() throws Exception {
        assertNotNull(controller);
    }
    
    @Test
    public void test() {
        webClient.get().uri("/1").exchange().expectStatus().is4xxClientError();
        webClient.get().uri("/10001").exchange().expectStatus().is4xxClientError();
    }

}
