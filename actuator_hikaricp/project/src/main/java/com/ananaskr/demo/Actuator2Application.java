package com.ananaskr.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Actuator2Application {

    @RequestMapping("/")
    public String home(){
        return "Hello ananaskr";
    }

    public static void main(String[] args) {
        SpringApplication.run(Actuator2Application.class, args);
    }

}
