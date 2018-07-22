package com.example.redis.demo.controller;

import com.example.redis.demo.model.User;
import com.example.redis.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserRestController {
    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET, value = "/getAllUsers")
    public List<User> getAllUsers() {
        List<User> listOfUsers = userService.getAllUsers();
        return listOfUsers;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/addUser")
    public User addUser(@RequestBody User user){
        user = userService.addUser(user);
        return user;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/updateUser")
    public User updateUser(@RequestBody User user){
        user = userService.updateUser(user);
        return user;
    }

    @RequestMapping(method = RequestMethod.DELETE, value="/deleteUser")
    public void deleteUser(@RequestBody User user){
        userService.deleteUser(user);
    }
}
