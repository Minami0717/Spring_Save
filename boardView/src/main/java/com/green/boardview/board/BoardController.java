package com.green.boardview.board;

import com.green.boardview.board.model.BoardEntity;
import com.green.boardview.cmt.CmtService;
import com.green.boardview.cmt.model.BoardCmtDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/board")
public class BoardController {
    private final BoardService service;
    private final CmtService cmtService;

    @Autowired
    public BoardController(BoardService service, CmtService cmtService) {
        this.service = service;
        this.cmtService = cmtService;
    }

    @GetMapping("/write")
    public String writeBoard() {
        return "writeBoard";
    }

    @PostMapping("/write")
    public String writeBoard(BoardEntity entity) {
        service.writeBoard(entity);
        return "redirect:/board";
    }

    @GetMapping
    public String selBoardAll(Model model) {
        model.addAttribute("boardList", service.selBoardAll());
        return "boardList";
    }

    @GetMapping("/{iboard}")
    public String boardDetail(@PathVariable int iboard, Model model) {
        model.addAttribute("board", service.selBoardById(setEntityById(iboard)));

        BoardCmtDto dto = new BoardCmtDto();
        dto.setIboard(iboard);
        model.addAttribute("cmt", cmtService.selCmt(dto));
        return "boardDetail";
    }

    @GetMapping("/modify/{iboard}")
    public String modBoard(@PathVariable int iboard, Model model) {
        model.addAttribute("board", service.selBoardById(setEntityById(iboard)));
        return "modifyBoard";
    }

    @PostMapping("/modify")
    public String modBoard(BoardEntity entity) {
        service.modBoard(entity);
        return "redirect:/board/" + entity.getIboard();
    }

    @GetMapping("/delete/{iboard}")
    public String delBoard(@PathVariable int iboard) {
        BoardCmtDto dto = new BoardCmtDto();
        dto.setIboard(iboard);
        cmtService.delCmt(dto);

        service.delBoard(setEntityById(iboard));
        return "redirect:/board";
    }

    public BoardEntity setEntityById(int iboard) {
        BoardEntity entity = new BoardEntity();
        entity.setIboard(iboard);
        return entity;
    }
}
