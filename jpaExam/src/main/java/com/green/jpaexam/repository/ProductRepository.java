package com.green.jpaexam.repository;

import com.green.jpaexam.entity.ProductEntity;
import com.green.jpaexam.product.model.ProductRes;
import com.green.jpaexam.product.model.ProductSelAllParam;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    @Query("select new com.green.jpaexam.product.model.ProductRes(p.number, p.name, p.price, p.stock, " +
            "p.providerEntity.name, p.categoryEntity.name, p.productDetailEntity.description, p.createdAt) " +
            "from ProductEntity p where p.name = :#{#param.productName} and p.price >= :#{#param.price}")
    List<ProductRes> selProductAll(Pageable pageable, ProductSelAllParam param);

//    @Query("select new com.green.jpaexam.product.model.ProductRes(p.number, p.name, p.price, p.stock, " +
//            "pv.name, c.name, d.description, p.createdAt) " +
//            "from ProductEntity p join p.productDetailEntity d join p.providerEntity pv join p.categoryEntity c")
//    List<ProductRes> selProductAll();
}
