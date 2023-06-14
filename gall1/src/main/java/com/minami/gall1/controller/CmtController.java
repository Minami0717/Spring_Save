package com.minami.gall1.controller;

import com.minami.gall1.model.CmtInsDto;
import com.minami.gall1.service.CmtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board/cmt")
public class CmtController {
    private final CmtService service;

    @Autowired
    public CmtController(CmtService service) {
        this.service = service;
    }

    @PostMapping
    public String postCmt(CmtInsDto dto) {
        service.insCmt(dto);
        return String.format("redirect:/board/view?id=%d&no=%d", dto.getGallId(), dto.getPostId());
    }
}
