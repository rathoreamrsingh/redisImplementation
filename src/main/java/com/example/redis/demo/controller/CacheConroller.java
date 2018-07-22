package com.example.redis.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/cache")
public class CacheConroller {

    @Autowired
    private CacheManager cacheManager;

    @GetMapping(value = "/all")
    public boolean clearAllCache() {
        boolean result = false;

        try {
            cacheManager.getCacheNames().parallelStream().forEach(name -> {
                System.out.print(name);
                cacheManager.getCache(name).clear();
            });
            result = true;
        } catch (Exception e) {
            result = false;
        }

        return result;

    }
}
