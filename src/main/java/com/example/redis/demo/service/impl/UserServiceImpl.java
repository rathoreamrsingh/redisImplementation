package com.example.redis.demo.service.impl;

import com.example.redis.demo.entity.Users;
import com.example.redis.demo.model.User;
import com.example.redis.demo.repository.UserRepository;
import com.example.redis.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository iUserRepository;

    @Cacheable(value = "users")
    @Override
    public List<User> getAllUsers() {

        List<User> listOfUser = maplistOfUsersWithUser((List<Users>)iUserRepository.findAll());
        return listOfUser;
    }

    @Override
    public User addUser(User user) {
        Users users = new Users();
        users.setFirstName(user.getFirstName());
        users.setLastName(user.getLastName());
        users.setUsername(user.getUserName());
        users = iUserRepository.save(users);
        user.setId(users.getId());
        return user;
    }

    @Override
    public void deleteUser(User user) {
        Users users = new Users();
        users.setFirstName(user.getFirstName());
        users.setLastName(user.getLastName());
        users.setUsername(user.getUserName());
        users.setId(user.getId());
        iUserRepository.delete(users);
    }

    @Override
    public User updateUser(User user) {
        Users users = new Users();
        users.setFirstName(user.getFirstName());
        users.setLastName(user.getLastName());
        users.setUsername(user.getUserName());
        users.setId(user.getId());
        users = iUserRepository.save(users);
        return user;
    }

    private List<User> maplistOfUsersWithUser(List<Users> listOfUsers) {
        List<User> result = new ArrayList<User>();

        for(Users users : listOfUsers){
            User user = new User();
            user.setId(users.getId());
            user.setFirstName(users.getFirstName());
            user.setLastName(users.getLastName());
            user.setUserName(users.getUsername());
            result.add(user);
        }

        return result;
    }
}
