package com.example.jpa1.product;

import com.example.jpa1.entity.ProductEntity;
import com.example.jpa1.product.model.ProductUpdDto;
import com.example.jpa1.product.model.ProductVo;
import com.example.jpa1.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRep;

    public ProductEntity updProduct(ProductUpdDto dto){
        ProductEntity result = productRep.getReferenceById(dto.getNumber());
        result.setPrice(dto.getPrice());
        result.setName(dto.getName());
        result.setStock(dto.getStock());
        return productRep.save(result);
    }

    public ProductVo getProduct(long number) {
        Optional<ProductEntity> optEntity = productRep.findById(number);
        if (optEntity.isEmpty()) return null;

        ProductEntity entity = optEntity.get();

        return ProductVo.builder()
                .number(entity.getNumber())
                .name(entity.getName())
                .price(entity.getPrice())
                .stock(entity.getStock())
                .build();
    }

    public List<ProductVo> getProductAll(String name){
        List<ProductEntity> list;

        if (name == null) {
            list = productRep.findAll(Sort.by(Sort.Direction.DESC, "number"));
        } else {
            list = productRep.findAllByName(name, Sort.by(Sort.Direction.DESC, "number"));
        }

        return list.stream().map(p -> ProductVo.builder()
                .number(p.getNumber())
                .name(p.getName())
                .price(p.getPrice())
                .stock(p.getStock())
                .build()
        ).toList();
    }

    public int delProduct(long number) {
        productRep.deleteById(number);
        return 1;
    }

    public List<ProductVo> getProductAllSearch(String name) {
        List<ProductEntity> list = productRep.findAllByNameContains(name);

        return list.stream().map(p -> ProductVo.builder()
                .number(p.getNumber())
                .name(p.getName())
                .price(p.getPrice())
                .stock(p.getStock())
                .build()
        ).toList();
    }
}
