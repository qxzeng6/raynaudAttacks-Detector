package com.raynaud.raynaudAttacksDetector.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

public class test {
    @Data
    @Entity
    @Table(name = "user")
    @EntityListeners(value = AuditingEntityListener.class)
    public class UserEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String workId;
        private String userName;
        @ManyToOne(optional = false)
        @JoinColumn(name = "department")
        private DepartmentEntity department;
        @CreatedDate
        private Date createTime;
        @LastModifiedDate
        private Date updateTime;

    }


}
