package com.example.redis.demo.service;

import com.example.redis.demo.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    public List<User> getAllUsers();

    public User addUser(User user);

    public void deleteUser(User user);

    public User updateUser(User user);
}
