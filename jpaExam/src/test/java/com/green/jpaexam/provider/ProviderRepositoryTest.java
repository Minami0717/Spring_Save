package com.green.jpaexam.provider;

import com.green.jpaexam.entity.ProductEntity;
import com.green.jpaexam.entity.ProviderEntity;
import com.green.jpaexam.repository.ProviderRepository;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

//@DataJpaTest
@Slf4j
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ProviderRepositoryTest {
    @Autowired
    private ProviderRepository rep;

    @Test
    @Rollback(value = false)
    void cascadeTest() {
//        ProviderEntity provider = ProviderEntity.builder()
//                .name("테스트 업체")
//                .build();
        ProviderEntity providerEntity = new ProviderEntity();
        providerEntity.setName("테스트 업체2");

        ProductEntity p1 = ProductEntity.builder().name("상품1").price(1000).stock(100).build();
        ProductEntity p2 = ProductEntity.builder().name("상품2").price(2000).stock(200).build();
        ProductEntity p3 = ProductEntity.builder().name("상품3").price(3000).stock(300).build();

        p1.setProviderEntity(providerEntity);
        p2.setProviderEntity(providerEntity);
        p3.setProviderEntity(providerEntity);

        providerEntity.getProductEntityList().addAll(Lists.newArrayList(p1, p2, p3));

        rep.save(providerEntity);
    }
}
