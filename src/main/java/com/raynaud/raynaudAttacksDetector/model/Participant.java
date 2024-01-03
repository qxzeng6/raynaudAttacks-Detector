package com.raynaud.raynaudAttacksDetector.model;


import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "participants")
@EntityListeners(value = AuditingEntityListener.class)
public class Participant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long participantId;
    private String userName;
    private String uuid;
    private LocalDateTime LastAttackDate;
//    private String token;

}
