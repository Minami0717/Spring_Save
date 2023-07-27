package com.example.messagetest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController {
    private final TestService service;

    @GetMapping
    public int sendSMS(String phoneNum) {
        return service.sendSMS(phoneNum);
    }
}
