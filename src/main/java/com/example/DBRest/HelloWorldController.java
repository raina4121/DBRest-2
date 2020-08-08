package com.example.DBRest;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloWorldController {

    @RequestMapping("/")
    public String index() {
        return "Greetings from index Spring Boot!";
    }

    @RequestMapping("/hello")
    public String hello() {
        return "Greetings from hello Spring Boot!";
    }

}