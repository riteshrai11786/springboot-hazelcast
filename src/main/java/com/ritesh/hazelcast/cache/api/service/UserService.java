package com.ritesh.hazelcast.cache.api.service;

import com.ritesh.hazelcast.cache.api.dao.UserRepository;
import com.ritesh.hazelcast.cache.api.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Cacheable(cacheNames = {"userCache"})
    public List<User> getUsers() {
        System.out.println("Hit the DB for 1st time");
        return userRepository.findAll();
    }

    @Cacheable(value = "userCache", key = "#id", unless = "#result==null")
    public Optional<User> getUser(int id) {
        System.out.println("Hit the DB for 1st time");
        return userRepository.findById(id);
    }

    @CacheEvict(value = "userCache")
    public String delete(int id) {
        userRepository.deleteById(id);
        return "User is deleted with id :: " + id;
    }


}
