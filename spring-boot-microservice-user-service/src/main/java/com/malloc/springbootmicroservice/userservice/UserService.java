package com.malloc.springbootmicroservice.userservice;

import java.util.List;

public interface UserService {
    
    List<User> get();
    
    User get(Long id);
    
    User get(String username);

}
