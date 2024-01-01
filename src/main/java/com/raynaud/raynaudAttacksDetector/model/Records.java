package com.raynaud.raynaudAttacksDetector.model;


import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Data
@Entity
@Table(name = "records")
@EntityListeners(value = AuditingEntityListener.class)

public class Records {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long attackId;
    @CreatedDate
    private Date AttackStamp;
    @Column(length = 255)
    private String location;

    private String uuid;

}
