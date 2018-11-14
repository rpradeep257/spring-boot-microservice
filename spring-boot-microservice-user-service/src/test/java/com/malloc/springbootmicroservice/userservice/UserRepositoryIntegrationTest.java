package com.malloc.springbootmicroservice.userservice;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.malloc.springbootmicroservice.userservice.User;
import com.malloc.springbootmicroservice.userservice.UserRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryIntegrationTest {
    
    @Autowired
    private UserRepository userRepository;

    @Test
    public void test_findByUsername() {
        User user = userRepository.findByUsername("user");
        assertNotNull(user);
    }

}
