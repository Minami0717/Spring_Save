package com.minami.gallproject.config.jpa;

//import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing
public class JpaConfiguration {
//    @PersistenceContext
//    private EntityManager em;
//
//    @Bean
//    public JPAQueryFactory query(){
//        return new JPAQueryFactory(em);
//    }
}