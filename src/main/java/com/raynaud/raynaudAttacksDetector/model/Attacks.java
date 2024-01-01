package com.raynaud.raynaudAttacksDetector.model;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;


@Data
@Entity
@Table(name = "attacks")
@EntityListeners(value = AuditingEntityListener.class)
public class Attacks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long attackId;
    @CreatedDate
    private LocalDate AttackDate;
    @CreationTimestamp
    private LocalTime AttackTime;
    @Enumerated(EnumType.STRING)
    private Position location;

    private String uuid;

    private String userName;


}
