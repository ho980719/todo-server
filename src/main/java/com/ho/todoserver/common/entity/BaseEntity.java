package com.ho.todoserver.common.entity;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {
    @CreatedDate
    private LocalDateTime createdDate;
    private Long createBy;
    @LastModifiedDate
    private LocalDateTime modifiedDate;
    private Long modifiedBy;
    @ColumnDefault("false")
    private Boolean deleted;
    private LocalDateTime deletedDate;
    private Long deletedBy;


    public void delete() {
        this.deleted = true;
        this.deletedDate = LocalDateTime.now();
    }
}
