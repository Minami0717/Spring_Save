package com.minami.gall.controller;

import com.minami.gall.service.GallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GallController {
    private final GallService service;

    @Autowired
    public GallController(GallService service) {
        this.service = service;
    }

    @GetMapping("main")
    public String main(Model model) {
        model.addAttribute("postList", service.getPostAll());
        return "main";
    }

    @GetMapping("header")
    public String header() { return "header"; }
}
