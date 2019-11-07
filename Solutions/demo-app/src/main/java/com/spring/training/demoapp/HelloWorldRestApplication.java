package com.spring.training.demoapp;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldRestApplication {
    @RequestMapping("/greet")
    public String greet(){
        return  "Hello Rest";
    }
}
