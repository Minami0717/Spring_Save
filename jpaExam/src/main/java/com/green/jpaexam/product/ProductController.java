package com.green.jpaexam.product;

import com.green.jpaexam.product.model.*;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService service;
    @PostMapping
    public ResponseEntity<ProductRes> postProduct(@RequestBody ProductDto dto) {
        return ResponseEntity.ok(service.saveProduct(dto));
    }

    @GetMapping
    public ResponseEntity<Page<ProductRes>> getProductAll(@PageableDefault(sort = "number",
            direction = Sort.Direction.DESC, size = 20) Pageable page) {
        return ResponseEntity.ok(service.getProductAll(page));
    }

    @GetMapping("/jpql")
    public ResponseEntity<List<ProductRes>> getProductAllJpql(@ParameterObject @PageableDefault(sort = "number",
            direction = Sort.Direction.DESC, size = 50) Pageable page, @ParameterObject ProductSelAllParam p) {
        return ResponseEntity.ok(service.getProductAllJpql(page, p));
    }

    @GetMapping("/qdsl")
    public ResponseEntity<List<ProductResQdsl>> getProductAllQdsl(@ParameterObject @PageableDefault(sort = "number",
            direction = Sort.Direction.DESC, size = 50) Pageable page, @Parameter(description = "검색")
        @RequestParam(required = false) String search) {
        return ResponseEntity.ok(service.getProductAllQdsl(page, search));
    }

    @GetMapping("/{number}")
    public ResponseEntity<ProductRes> getProduct(@Parameter(description = "상품 PK") @PathVariable Long number) {
        return ResponseEntity.ok(service.getProduct(number));
    }

    @PutMapping
    public ResponseEntity<ProductRes> putProduct(@RequestBody ProductUpdDto dto) {
        return ResponseEntity.ok(service.updProduct(dto));
    }

    @DeleteMapping
    public ResponseEntity<Integer> delProduct(@RequestParam Long number) {
        service.delProduct(number);
        return ResponseEntity.ok(1);
    }
}
