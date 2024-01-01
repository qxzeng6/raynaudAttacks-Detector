package com.raynaud.raynaudAttacksDetector.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

@Data
public class attackDto {
    private String position;
//    private LocalDateTime attackStamp;
    @CreatedDate
    private LocalDate attackDate;
    @CreationTimestamp
    private LocalTime attackTime;
    private String uuid;
    private String userName;


}
