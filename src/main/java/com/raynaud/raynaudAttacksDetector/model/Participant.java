package com.raynaud.raynaudAttacksDetector.model;


import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

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

}
