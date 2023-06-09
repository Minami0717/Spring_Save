package com.minami.gall1.repository;

import com.minami.gall1.model.Cmt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CmtRepository extends JpaRepository<Cmt, Integer> {
}
