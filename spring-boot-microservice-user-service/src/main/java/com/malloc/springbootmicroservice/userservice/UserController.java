package com.malloc.springbootmicroservice.userservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/userservice")
public class UserController {
  
    @Autowired
    private UserService userService;
  
    @GetMapping
    @RequestMapping(method = RequestMethod.GET)
    public List<User> getUsers(){            
        return userService.get();
    }
    
    @GetMapping
    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public User getUsers(@PathVariable Long id){            
        return userService.get(id);
    }
    
   /* @GetMapping
    @RequestMapping(method = RequestMethod.GET, path = "/{username}")
    public User getUsers(@PathVariable String username){            
        return userService.get(username);
    }*/
}