package com.green.todoapp;

import com.green.todoapp.model.TodoInsDto;
import com.green.todoapp.model.TodoUpdDto;
import com.green.todoapp.model.TodoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todo")
public class TodoController {
    private final TodoService service;

    @Autowired
    public TodoController(TodoService service) {
        this.service = service;
    }

    @PostMapping
    public int postTodo(@RequestBody TodoInsDto dto) {
        return service.insTodo(dto);
    }

    @GetMapping
    public List<TodoVo> getTodo() {
        return service.selTodo();
    }

    @PatchMapping
    public int patchTodo(@RequestBody TodoUpdDto dto) {
        return service.updTodo(dto);
    }

    @DeleteMapping
    public int delTodo(@RequestParam int itodo) {
        return service.delTodo(itodo);
    }
}
