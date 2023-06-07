package com.minami.gall.repository;

import com.minami.gall.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GallRepository extends JpaRepository<Post, Integer> {
}
