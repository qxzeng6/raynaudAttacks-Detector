package com.raynaud.raynaudAttacksDetector.model;


import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Data
@Entity
@Table(name = "clinicians")
@EntityListeners(value = AuditingEntityListener.class)
public class Clinicians {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clinicianId;
    private String userName;
    private String password;
}
