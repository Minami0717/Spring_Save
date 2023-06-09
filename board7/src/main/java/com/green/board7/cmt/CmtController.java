package com.green.board7.cmt;

import com.green.board7.cmt.model.BoardCmtDelDto;
import com.green.board7.cmt.model.BoardCmtInsDto;
import com.green.board7.cmt.model.BoardCmtDto;
import com.green.board7.cmt.model.BoardCmtVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/board")
public class CmtController {
    private final CmtService service;

    @Autowired
    public CmtController(CmtService service) {
        this.service = service;
    }

    @PostMapping("/cmt")
    public int postCmt(@RequestBody BoardCmtInsDto dto) {
        return service.insCmt(dto);
    }

    @DeleteMapping("/cmt")
    public int delCmt(BoardCmtDelDto dto) {
        return service.delCmt(dto);
    }

    @GetMapping("/{iboard}/cmt")
    public List<BoardCmtVo> getCmt(@PathVariable int iboard) {
        BoardCmtDto dto = new BoardCmtDto();
        dto.setIboard(iboard);
        return service.selCmt(dto);
    }
}
