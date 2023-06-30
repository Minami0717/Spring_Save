package com.example.nottodolisttest.useList;

import com.example.nottodolisttest.model.UseListInsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UseListService {
    private final UseListMapper mapper;

    public int insUseList(List<UseListInsDto> dto) {
        return mapper.insUseList(dto);
    }
}
