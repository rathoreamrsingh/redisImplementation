package com.example.redis.demo.repository;

import com.example.redis.demo.entity.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<Users, Integer> {
    public List<Users> findByLastName(String name);
}
