package com.minami.gall1.service;

import com.minami.gall1.mapper.CmtMapper;
import com.minami.gall1.model.CmtInsDto;
import com.minami.gall1.model.CmtVo;
import com.minami.gall1.repository.CmtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CmtService {
    private final CmtRepository repository;
    private final CmtMapper mapper;

    @Autowired
    public CmtService(CmtRepository repository, CmtMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public int selCmtNum(int postId) {
        return mapper.selCmtNum(postId);
    }

    public List<CmtVo> selCmtByPostId(int postId) {
        return mapper.selCmtByPostId(postId);
    }

    public int insCmt(CmtInsDto dto) {
        return mapper.insCmt(dto);
    }
}
