package com.accenture.academy.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestController {
    @GetMapping(path = "/hello")
    public String getHello(){
        return "Howdy partner from accenture!";
    }

}
