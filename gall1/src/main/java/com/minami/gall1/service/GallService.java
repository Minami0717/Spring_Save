package com.minami.gall1.service;

import com.minami.gall1.model.Post;
import com.minami.gall1.repository.GallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GallService {
    private final GallRepository repository;

    @Autowired
    public GallService(GallRepository repository) {
        this.repository = repository;
    }

    public List<Post> selPost() {
        return repository.findAll();
    }
}
