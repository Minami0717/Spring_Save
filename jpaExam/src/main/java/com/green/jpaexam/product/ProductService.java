package com.green.jpaexam.product;

import com.green.jpaexam.product.model.*;
import com.green.jpaexam.repository.CategoryRepository;
import com.green.jpaexam.entity.ProductDetailEntity;
import com.green.jpaexam.entity.ProductEntity;
import com.green.jpaexam.repository.ProductRepository;
import com.green.jpaexam.repository.ProviderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final ProductDao dao;
    private final ProductRepository rep;
    private final CategoryRepository categoryRepository;
    private final ProviderRepository providerRepository;
    private final ProductQdsl qdsl;

    public ProductRes saveProduct(ProductDto dto) {
        ProductDetailEntity detailEntity = ProductDetailEntity.builder()
                .description(dto.getDescription())
                .build();

        ProductEntity entity = ProductEntity.builder()
                .name(dto.getName())
                .price(dto.getPrice())
                .stock(dto.getStock())
                .categoryEntity(categoryRepository.findById(dto.getCategoryId()).get())
                .providerEntity(providerRepository.findById(dto.getProviderId()).get())
                .build();

        entity.setProductDetailEntity(detailEntity);

        rep.save(entity);

        return ProductRes.builder()
                .number(entity.getNumber())
                .name(entity.getName())
                .price(entity.getPrice())
                .stock(entity.getStock())
                .categoryNm(entity.getCategoryEntity().getName())
                .providerNm(entity.getProviderEntity().getName())
                .description(detailEntity.getDescription())
                //.createdAt(entity.getCreatedAtDateTime())
                .build();
    }

    public Page<ProductRes> getProductAll(Pageable page) {
        return dao.getProductAll(page);
    }

    public ProductRes getProduct(Long number) {
        return dao.getProduct(number);
    }

    public ProductRes updProduct(ProductUpdDto dto) {
        ProductEntity entity = ProductEntity.builder()
                .number(dto.getNumber())
                .name(dto.getName())
                .price(dto.getPrice())
                .stock(dto.getStock())
                .build();

        return dao.updProduct(entity);
    }

    public void delProduct(Long number) {
        dao.delProduct(number);
    }

    public List<ProductRes> getProductAllJpql(Pageable page, ProductSelAllParam p) {
        return rep.selProductAll(page, p);
    }

    public List<ProductResQdsl> getProductAllQdsl(Pageable page, String search) {
        return qdsl.selProductAll(page, search);
    }
}
