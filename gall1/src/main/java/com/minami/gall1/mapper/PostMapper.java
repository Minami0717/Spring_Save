package com.minami.gall1.mapper;

import com.minami.gall1.model.BestPostVo;
import com.minami.gall1.model.PostInsDto;
import com.minami.gall1.model.PostSelDto;
import com.minami.gall1.model.PostVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostMapper {
    List<BestPostVo> selBestPost();
    List<PostVo> selPostByGallId(PostSelDto dto);
    int insPost(PostInsDto dto);
    int selPostCount(int gallId);
}
