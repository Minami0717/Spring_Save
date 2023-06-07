package com.green.first1.board;

import org.springframework.web.bind.annotation.*;

@RestController
public class BoardController {

    //form
    @PostMapping("/board")
    public String postBoard(BoardEntity entity) {
        System.out.println(entity);
        return "글 등록 완료";
    }

    //json
    @PostMapping(path="/board2")
    @CrossOrigin
    public String postBoard2(@RequestBody BoardEntity entity) {
        System.out.println(entity);
        return "{\"result\": 1}";
    }

    @GetMapping("/board")
    public String getBoard() {
        return "글 리스트 출력";
    }

    @GetMapping("/board/{iboard}")
    public String getBoardDetail(@PathVariable int iboard) {
        return iboard + "글 디테일";
    }

    @PutMapping("/board")
    public String putBoard() {
        return "글 수정 완료";
    }

    @DeleteMapping("/board")
    public String delBoard() {
        return "글 삭제 완료";
    }
}
