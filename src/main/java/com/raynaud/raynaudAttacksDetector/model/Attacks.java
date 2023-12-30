package com.raynaud.raynaudAttacksDetector.model;


import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Data
@Entity
@Table(name = "attacks")
@EntityListeners(value = AuditingEntityListener.class)
public class Attacks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long attackId;
    private Date AttackStamp;
    private Position location;

}
