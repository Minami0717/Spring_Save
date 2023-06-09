package com.minami.gall1.controller;

import com.minami.gall1.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class MainController {
    private final PostService service;

    @Autowired
    public MainController(PostService service) {
        this.service = service;
    }

    @GetMapping
    public String getBestPost(Model model) {
        model.addAttribute("postList", service.selBestPost());
        return "main";
    }

    @GetMapping("header")
    public String header() { return "header"; }
}
