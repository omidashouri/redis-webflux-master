package com.vinsguru.redisspring.fib.controller;

import com.vinsguru.redisspring.fib.service.FibService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("fib")
public class FibController {

    @Autowired
    private FibService service;

//    http://localhost:8080/fib/40
    @GetMapping("{index}")
    public Mono<Integer> getFib(@PathVariable int index){
        return Mono.fromSupplier(() -> this.service.getFib(index));
    }

    //    http://localhost:8080/fib/40/name/omid
    @GetMapping("{index}/name/{name}")
    public Mono<Integer> getFibName(@PathVariable int index, @PathVariable String name){
        return Mono.fromSupplier(() -> this.service.getFib(index,name));
    }

    @GetMapping("{index}/clear")
    public Mono<Void> clearCache(@PathVariable int index){
        return Mono.fromRunnable(() -> this.service.clearCache(index));
    }

}
