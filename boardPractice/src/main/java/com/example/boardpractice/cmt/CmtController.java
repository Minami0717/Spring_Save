package com.example.boardpractice.cmt;

import com.example.boardpractice.cmt.model.*;
import jakarta.validation.constraints.Min;
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

    @PostMapping("/{iboard}/cmt")
    public int postCmt(@PathVariable int iboard, @RequestBody CmtInsDto dto) {
        CmtEntity entity = new CmtEntity();
        entity.setIboard(iboard);
        entity.setCtnt(dto.getCtnt());
        entity.setIuser(dto.getIuser());

        return service.insCmt(entity);
    }

    @PutMapping("/cmt/{iboardCmt}")
    public int putCmt(@PathVariable int iboardCmt, @RequestBody CmtUpdDto dto) {
        CmtEntity entity = new CmtEntity();
        entity.setIboardCmt(iboardCmt);
        entity.setCtnt(dto.getCtnt());
        entity.setIuser(dto.getIuser());

        return service.updCmt(entity);
    }

    @DeleteMapping("/cmt/{iboardCmt}")
    public int delCmt(@PathVariable int iboardCmt, @RequestParam int iuser) {
        CmtDelDto dto = new CmtDelDto();
        dto.setIboardCmt(iboardCmt);
        dto.setIuser(iuser);
        return service.delCmt(dto);
    }

    @GetMapping("/{iboard}/cmt")
    public CmtRes getCmt(@PathVariable int iboard,
                              @RequestParam @Min(value = 1) int page,
                              @RequestParam(defaultValue = "5") int row) {

        CmtSelDto dto = new CmtSelDto();
        dto.setIboard(iboard);
        dto.setPage(page);
        dto.setRow(row);
        return service.selCmt(dto);
    }
}
