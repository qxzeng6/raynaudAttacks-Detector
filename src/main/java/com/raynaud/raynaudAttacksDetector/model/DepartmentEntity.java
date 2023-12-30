package com.raynaud.raynaudAttacksDetector.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Data
@Entity
@Table(name = "department")
@EntityListeners(value = AuditingEntityListener.class)
public class DepartmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String deptName;
    @CreatedDate
    private Date createTime;
    @LastModifiedDate
    private Date updateTime;
}

