package com.green.board1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {
    private final BoardService service;

    @Autowired
    public BoardController(BoardService service) {
        this.service = service;
    }

    @PostMapping("/write")
    public String boardPost(BoardEntity entity, Model model) {
        service.insBoard(entity);
        return selBoardAll(model);
    }

    @PutMapping
    public int boardPut(@RequestBody BoardEntity entity) {
        return service.modBoard(entity);
    }

    @DeleteMapping("/{iboard}")
    public int boardDel(@PathVariable int iboard) {
        BoardEntity entity = new BoardEntity();
        entity.setIboard(iboard);
        return service.delBoard(entity);
    }

    @GetMapping
    @ResponseBody
    public List<BoardEntity> selBoardAll() {
        return service.selBoardAll();
    }

    @GetMapping("/{iboard}")
    @ResponseBody
    public BoardEntity selBoardById(@PathVariable int iboard) {
        BoardEntity entity = new BoardEntity();
        entity.setIboard(iboard);
        return service.selBoardById(entity);
    }

    @GetMapping("/view")
    public String selBoardAll(Model model) {
        List<BoardEntity> boardList = service.selBoardAll();
        model.addAttribute("boardList", boardList);
        return "boardList";
    }

    @GetMapping("/view/{iboard}")
    public String selBoardById(@PathVariable int iboard, Model model) {
        BoardEntity entity = new BoardEntity();
        entity.setIboard(iboard);
        model.addAttribute("board", service.selBoardById(entity));
        return "boardView";
    }

    @GetMapping("/write")
    public String boardWrite() {
        return "boardWrite";
    }
}
