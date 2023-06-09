package com.minami.gall1.service;

import com.minami.gall1.mapper.GallMapper;
import com.minami.gall1.model.GallVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GallService {
    private final GallMapper mapper;

    @Autowired
    public GallService(GallMapper mapper) {
        this.mapper = mapper;
    }

    public GallVo selGallInfoById(int id) {
        return mapper.selGallInfoById(id);
    }
}
