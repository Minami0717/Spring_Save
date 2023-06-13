package com.green.todoapp;

import com.green.todoapp.model.TodoInsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/todo")
public class TodoController {
    private final TodoService service;

    @Autowired
    public TodoController(TodoService service) {
        this.service = service;
    }

    @GetMapping
    public String getTodo() {
        return "test";
    }

    @PostMapping
    public int postTodo(@RequestBody TodoInsDto dto) {
        return service.insTodo(dto);
    }
}
