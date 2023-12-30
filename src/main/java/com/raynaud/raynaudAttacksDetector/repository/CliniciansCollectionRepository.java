package com.raynaud.raynaudAttacksDetector.repository;

import com.raynaud.raynaudAttacksDetector.model.Clinicians;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CliniciansCollectionRepository extends JpaRepository<Clinicians, Long> {


    Boolean existsByUserName(String userName);
    Boolean existsByUserNameAndPassword(String userName, String password);
}
