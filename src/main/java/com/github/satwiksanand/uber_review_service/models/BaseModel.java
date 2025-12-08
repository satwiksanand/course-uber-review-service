package com.github.satwiksanand.uber_review_service.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    protected LocalDateTime createdAt;
    protected LocalDateTime updatedAt;

    @PrePersist
    public void createdAtModifier(){
        this.createdAt = LocalDateTime.now();
    }

    @PreUpdate
    public void updatedAtModifier(){
        this.updatedAt = LocalDateTime.now();
    }
}
