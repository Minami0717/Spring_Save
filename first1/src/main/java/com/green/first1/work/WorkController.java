package com.green.first1.work;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/work")
public class WorkController {

    @GetMapping("/hello")
    public String hello() {
        return "<h1>hello</h1>";
    }
}
