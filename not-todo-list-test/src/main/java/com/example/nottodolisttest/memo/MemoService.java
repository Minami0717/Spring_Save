package com.example.nottodolisttest.memo;

import com.example.nottodolisttest.memo.model.MemoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemoService {
    private final MemoMapper mapper;

    @Autowired
    public MemoService(MemoMapper mapper) {
        this.mapper = mapper;
    }

    public int updMemo(MemoDto dto) {
        return mapper.updMemo(dto);
    }
}
