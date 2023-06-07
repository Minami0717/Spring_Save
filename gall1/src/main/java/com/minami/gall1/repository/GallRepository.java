package com.minami.gall1.repository;

import com.minami.gall1.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GallRepository extends JpaRepository<Post, Integer> {
}
