package com.example.jpa1.repository;

import com.example.jpa1.entity.ProductDetail;
import com.example.jpa1.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDetailRepository extends JpaRepository<ProductDetail, Long> {
}
