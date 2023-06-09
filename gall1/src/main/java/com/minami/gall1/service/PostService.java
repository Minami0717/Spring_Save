package com.minami.gall1.service;

import com.minami.gall1.mapper.PostMapper;
import com.minami.gall1.model.BestPostVo;
import com.minami.gall1.model.PostInsDto;
import com.minami.gall1.model.PostSelDto;
import com.minami.gall1.model.PostVo;
import com.minami.gall1.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    private final PostRepository repository;
    private final PostMapper mapper;
    private final CmtService cmtService;

    @Autowired
    public PostService(PostRepository repository, PostMapper mapper, CmtService cmtService) {
        this.repository = repository;
        this.mapper = mapper;
        this.cmtService = cmtService;
    }

//    public List<Post> getPost() {
//        return repository.findAll();
//    }

    public List<BestPostVo> selBestPost() {
        List<BestPostVo> postList = mapper.selBestPost();
        for (BestPostVo post : postList) {
            post.setCmtNum(cmtService.selCmtNum(post.getId()));
        }

        return postList;
    }

    public List<PostVo> selPostByGallId(PostSelDto dto) {
        dto.setStartIdx((dto.getPage() - 1) * dto.getListNum());

        List<PostVo> postList = mapper.selPostByGallId(dto);
        for (PostVo post : postList) {
            post.setCmtNum(cmtService.selCmtNum(post.getId()));
        }

        return postList;
    }

    public int insPost(PostInsDto dto) {
        return mapper.insPost(dto);
    }

    public int getMaxPage(PostSelDto dto) {
        int postCount = getPostCount(dto.getGallId());
        return (int) Math.ceil((double) postCount / dto.getListNum());
    }

    public int getPostCount(int gallId) {
        return mapper.selPostCount(gallId);
    }
}
