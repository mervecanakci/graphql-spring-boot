package com.vendeton.graphql.service;

import com.vendeton.graphql.exception.UserNotFoundException;
import com.vendeton.graphql.model.User;
import com.vendeton.graphql.model.UserRequest;
import com.vendeton.graphql.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    List <User> getAllUsers();
    User getUserById(Long id);
    User createUser(UserRequest userRequest);
   User updateUser(UserRequest userRequest);
    void deleteUser(Long id);


}