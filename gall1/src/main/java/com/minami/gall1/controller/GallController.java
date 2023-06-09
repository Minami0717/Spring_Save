package com.minami.gall1.controller;

import com.minami.gall1.model.PostInsDto;
import com.minami.gall1.model.PostSelDto;
import com.minami.gall1.service.GallService;
import com.minami.gall1.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/board")
public class GallController {
    private final GallService service;
    private final PostService postService;

    @Autowired
    public GallController(GallService service, PostService postService) {
        this.service = service;
        this.postService = postService;
    }

    @GetMapping("/lists")
    public String getPost(Model model, @RequestParam int id, @RequestParam(defaultValue = "1") int page,
                          @RequestParam(defaultValue = "50", name = "list-num") int listNum) {
        PostSelDto dto = new PostSelDto();
        dto.setPage(page);
        dto.setGallId(id);
        dto.setListNum(listNum);

        model.addAttribute("gallInfo", service.selGallInfoById(id));
        model.addAttribute("postList", postService.selPostByGallId(dto));
        model.addAttribute("nowPage", page);
        model.addAttribute("maxPage", postService.getMaxPage(dto));
        model.addAttribute("postCount", postService.getPostCount(id));
        return "gallMain";
    }

    @GetMapping("/write")
    public String writePost(Model model, @RequestParam int id) {
        model.addAttribute("gallInfo", service.selGallInfoById(id));
        return "writePost";
    }

    @PostMapping("/write")
    public String writePost(PostInsDto dto) {
        postService.insPost(dto);
        return "redirect:/board/lists?id=" + dto.getGallId();
    }
}
