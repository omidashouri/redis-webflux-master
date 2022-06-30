
package com.vinsguru.redisspring.fib.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.stream.IntStream;

@Service
public class FibServiceSchedule {

    @Autowired
    FibService fibService;

//    @Scheduled(fixedRate = 20_000)
    public void updateCache() {
        System.out.println("cache fib cache again");
        IntStream.rangeClosed(35,40).forEach(i->fibService.getFib(i));
    }

}
