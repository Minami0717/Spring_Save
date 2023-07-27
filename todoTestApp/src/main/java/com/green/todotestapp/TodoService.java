package com.green.todotestapp;

import com.green.todotestapp.model.*;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TodoService {
    TodoRes insTodo(TodoInsParam p);
    List<TodoVo> selTodo();
    int updTodo(TodoUpdDto dto);
}
