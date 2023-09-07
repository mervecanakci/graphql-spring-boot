package com.vendeton.graphql.service;

import com.vendeton.graphql.exception.UserNotFoundException;
import com.vendeton.graphql.model.User;
import com.vendeton.graphql.model.UserRequest;
import com.vendeton.graphql.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service // @Service: Spring Boot uygulamasında servis katmanı sınıfı olduğunu belirtmek için kullanılır
@AllArgsConstructor // @AllArgsConstructor: tüm sınıf alanları için argümanlı bir constructor oluşturur
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository
                .findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found!!!"));
    }

    public User createUser(UserRequest userRequest) {
        User user =
                User.builder()
                        .username(userRequest.getUsername())
                        .email(userRequest.getEmail())
                        .role(userRequest.getRole())
                        .build();
        return userRepository.save(user);

    }

    public User updateUser(UserRequest userRequest) {
        User existing = getUserById(userRequest.getId()); // existing: var olan
        existing.setRole(userRequest.getRole());
        existing.setUsername(userRequest.getUsername());
        existing.setEmail(userRequest.getEmail());
        return userRepository.save(existing);
    }

    public void deleteUser(Long id) {
        User existing = getUserById(id);
        userRepository.delete(existing);
    }
}
