package com.example.springdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @GetMapping("hello-world")
    public ReturnedEntity getSampleString(){
        ReturnedEntity entity = new ReturnedEntity("Tomasz Dawid",30);
        return entity;
    }

    record ReturnedEntity(String name, Integer age){}

}
