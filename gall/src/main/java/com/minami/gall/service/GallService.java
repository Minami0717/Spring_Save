package com.minami.gall.service;

import com.minami.gall.entity.Post;
import com.minami.gall.repository.GallRepository;
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

    public List<Post> getPostAll() {
        return repository.findAll();
    }
}
