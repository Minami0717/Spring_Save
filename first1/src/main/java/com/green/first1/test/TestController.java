package com.green.first1.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    //queryString
    @GetMapping("/test1")
    public String test1(String name, int age) {
        return String.format("contents : test1, name: %s, age: %d", name, age);
    }

    @GetMapping("/test2")
    public String test2(@RequestParam(required = false) String name, @RequestParam(defaultValue = "0") int age) {
        return String.format("contents : test1, name: %s, age: %d", name, age);
    }
}
