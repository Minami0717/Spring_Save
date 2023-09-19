package com.green.jpaexam.product;

import com.green.jpaexam.product.model.ProductResQdsl;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.JPQLQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

import static com.green.jpaexam.entity.QCategoryEntity.categoryEntity;
import static com.green.jpaexam.entity.QProductDetailEntity.productDetailEntity;
import static com.green.jpaexam.entity.QProductEntity.productEntity;
import static com.green.jpaexam.entity.QProviderEntity.providerEntity;

@Slf4j
@Component
@RequiredArgsConstructor
public class ProductQdsl {
    private final JPAQueryFactory jpaQueryFactory;

    public List<ProductResQdsl> selProductAll(Pageable page, String search) {
//        BooleanBuilder whereBuilder = new BooleanBuilder();
//        if (search != null) {
//            whereBuilder.and(productEntity.name.contains(search));
//        }

        JPQLQuery<ProductResQdsl> query = jpaQueryFactory.select(Projections.bean(ProductResQdsl.class,
                        productEntity.number, productEntity.name, productEntity.price, productEntity.stock,
                        providerEntity.name.as("providerNm"), categoryEntity.name.as("categoryNm"),
                        productDetailEntity.description, productEntity.createdAt,
                        ExpressionUtils.as(JPAExpressions.select(productEntity.number.count()).from(productEntity),
                                "totalCnt")))
                .from(productEntity)
                .join(productEntity.productDetailEntity, productDetailEntity)
                .join(productEntity.providerEntity, providerEntity)
                .join(productEntity.categoryEntity, categoryEntity)
                .where(nameSearch(search),
                        productEntity.number.goe(JPAExpressions.select(productEntity.number.count()).from(productEntity)))
                .orderBy(getAllOrderSpecifiers(page))
                .offset(page.getOffset())
                .limit(page.getPageSize());

        return query.fetch();

//        return jpaQueryFactory
//                .select(new QProductRes(productEntity.number, productEntity.name, productEntity.price,
//                        productEntity.stock, productEntity.providerEntity.name, productEntity.categoryEntity.name,
//                        productEntity.productDetailEntity.description, productEntity.createdAt))
//                .from(productEntity)
//                .where(productEntity.name.eq(p.getProductName()), productEntity.price.goe(p.getPrice()))
//                .fetch();
    }

    private BooleanExpression nameSearch(String name) {
        return name != null ? productEntity.name.contains(name).or(productDetailEntity.description.contains(name)) : null;
    }
//    private BooleanExpression desSearch(String name) {
//        return name != null ? productDetailEntity.description.contains(name) : null;
//    }
    private BooleanExpression priceGoe(Integer price) {
        return price != null ? productEntity.price.goe(price) : null;
    }

    private OrderSpecifier[] getAllOrderSpecifiers(Pageable pageable) {
        List<OrderSpecifier> orders = new LinkedList<>();
        if (!pageable.getSort().isEmpty()) {
            for (Sort.Order order : pageable.getSort()) {
                Order direction = order.getDirection().isAscending() ? Order.ASC : Order.DESC;

                switch (order.getProperty().toLowerCase()) {
                    case "number" -> orders.add(new OrderSpecifier(direction, productEntity.number));
                    case "product_name" -> orders.add(new OrderSpecifier(direction, productEntity.name));
                    case "price" -> orders.add(new OrderSpecifier(direction, productEntity.price));
                    case "category_name" -> orders.add(new OrderSpecifier(direction, categoryEntity.name));
                }
            }
        }

        return orders.toArray(OrderSpecifier[]::new);
    }
}
