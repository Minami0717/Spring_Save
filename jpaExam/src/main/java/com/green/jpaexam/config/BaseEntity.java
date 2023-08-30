package com.green.jpaexam.config;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@SuperBuilder
@NoArgsConstructor
public class BaseEntity {

    @CreatedDate
    @Column(updatable = false)
    @ColumnDefault(value = "current_timestamp")
    private LocalDateTime createdAt;

    @LastModifiedDate
    @ColumnDefault(value = "current_timestamp")
    private LocalDateTime updatedAt;

    public String getCreatedAtDateTime() {
        return this.createdAt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm"));
    }

    public String getUpdatedAtDateTime() {
        return this.updatedAt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm"));
    }
}
