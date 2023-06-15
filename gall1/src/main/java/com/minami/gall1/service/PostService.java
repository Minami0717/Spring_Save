package com.minami.gall1.service;

import com.minami.gall1.mapper.PostMapper;
import com.minami.gall1.model.*;
import com.minami.gall1.repository.PostRepository;
import com.minami.gall1.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class PostService {
    private final PostRepository repository;
    private final PostMapper mapper;
    private final CmtService cmtService;

    @Value("${file.dir}")
    private String fileDir;

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

    public int insPost(List<MultipartFile> imgList, PostInsDto dto) {
        if (imgList.isEmpty()) {
            return mapper.insPost(dto);
        }

        if (mapper.insPost(dto) == 0) {
            return 0;
        }

        for (MultipartFile img : imgList) {
            String originFileName = img.getOriginalFilename();
            String savedFileName = FileUtils.makeRandomFileNm(originFileName);
            String savedFilePath = String.format("%s/%s", fileDir, savedFileName);

            File file = new File(savedFilePath);

            try {
                img.transferTo(file);
            } catch (IOException e) {
                e.printStackTrace();
                return 0;
            }

            ImgInsDto imgDto = new ImgInsDto();
            imgDto.setImgPath(String.format("/image/post/%s", savedFileName));
            imgDto.setPostId(dto.getPostId());

            mapper.insPostImg(imgDto);
        }

        return 1;
    }

    public int getMaxPage(PostSelDto dto) {
        int postCount = getPostCount(dto.getGallId());
        return (int) Math.ceil((double) postCount / dto.getListNum());
    }

    public int getPostCount(int gallId) {
        return mapper.selPostCount(gallId);
    }

    public PostDetailVo selPostDetail(int id) {
        PostDetailVo vo = mapper.selPostDetail(id);
        vo.setCmtNum(cmtService.selCmtNum(vo.getId()));
        vo.setCmt(cmtService.selCmtByPostId(id));
        vo.setImgList(mapper.selPostImg(id));

        return vo;
    }

    public int updHits(int id) {
        return mapper.updHits(id);
    }

    public int updReco(int id) {
        return mapper.updReco(id);
    }

    public int updDeco(int id) {
        return mapper.updDeco(id);
    }
}
