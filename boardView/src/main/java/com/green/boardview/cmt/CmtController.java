package com.green.boardview.cmt;

import com.green.boardview.cmt.model.BoardCmtInsDto;
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
    public String insCmt(BoardCmtInsDto dto) {
        service.insCmt(dto);
        return "redirect:/board/" + dto.getIboard();
    }
}
