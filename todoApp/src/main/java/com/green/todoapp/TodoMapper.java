package com.green.todoapp;

import com.green.todoapp.model.TodoInsDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TodoMapper {
    int insTodo(TodoInsDto dto);
}
