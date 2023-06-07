package com.example.boardpractice.board;

import com.example.boardpractice.board.model.*;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/board")
public class BoardController {
    private final BoardService service;

    @Autowired
    public BoardController(BoardService service) {
        this.service = service;
    }

    @PostMapping
    public int postBoard(@RequestBody BoardInsDto dto) {
        return service.insBoard(dto);
    }

    @GetMapping
    public List<BoardVo> getBoard(@RequestParam(defaultValue = "1") @Min(value = 1, message = "1 이상") int page,
                                  @RequestParam(defaultValue = "40") int row) {

        BoardSelDto dto = BoardSelDto.builder()
                .page(page)
                .row(row)
                .build();

        return service.selBoard(dto);
    }

    @GetMapping("/maxpage")
    public int getMaxpage(int row) {
        BoardRowDto dto = new BoardRowDto();
        dto.setRow(row);
        return service.getMaxpage(dto);
    }

    @GetMapping("/{iboard}")
    public BoardDetailRes getBoardById(@PathVariable int iboard) {
        BoardIdDto dto = new BoardIdDto();
        dto.setIboard(iboard);
        return service.selBoardById(dto);
    }

    @DeleteMapping
    public int delBoard(@RequestBody BoardDelDto dto) throws Exception {
        return service.delBoard(dto);
    }

    @PutMapping
    public int putBoard(@RequestBody BoardUpdDto dto) {
        return service.updBoard(dto);
    }
}