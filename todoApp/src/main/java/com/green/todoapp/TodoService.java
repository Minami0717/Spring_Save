package com.green.todoapp;

import com.green.todoapp.model.TodoEntity;
import com.green.todoapp.model.TodoInsDto;
import com.green.todoapp.model.TodoUpdDto;
import com.green.todoapp.model.TodoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {
    private final TodoMapper mapper;

    @Autowired
    public TodoService(TodoMapper mapper) {
        this.mapper = mapper;
    }

    public int insTodo(TodoInsDto dto) {
        TodoEntity entity = new TodoEntity();
        entity.setCtnt(dto.getCtnt());

        return mapper.insTodo(entity) == 0 ? -1 : entity.getItodo();
    }

    public List<TodoVo> selTodo() {
        return mapper.selTodo();
    }

    public int updTodo(TodoUpdDto dto) {
        TodoEntity entity = new TodoEntity();
        entity.setItodo(dto.getItodo());

        return mapper.updTodo(entity) == 0 ? -1 : entity.getFinishYn();
    }

    public int delTodo(int itodo) {
        return mapper.delTodo(itodo);
    }
}
