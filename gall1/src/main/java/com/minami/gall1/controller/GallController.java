package com.minami.gall1.controller;

import com.minami.gall1.service.GallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class GallController {
    private final GallService service;

    @Autowired
    public GallController(GallService service) {
        this.service = service;
    }

    @GetMapping
    public String getPost(Model model) {
        model.addAttribute("postList", service.selPost());
        return "main";
    }

    @GetMapping("header")
    public String header() { return "header"; }
}
