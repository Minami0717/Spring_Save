package com.minami.gall1.mapper;

import com.minami.gall1.model.GallVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GallMapper {
    GallVo selGallInfoById(int id);
}
