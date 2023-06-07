package com.spring.redis.entity;

import com.spring.redis.intfc.Cacheable;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Table(name = "organization")
@Entity
public class Organization implements Serializable, Cacheable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orgId;
    private String orgName;
    private String orgCategory;
    private LocalDateTime createdOn;
    private String createdBy;
    private boolean isActive;
    private LocalDateTime UpdatedOn;
    private String UpdatedBy;
}
