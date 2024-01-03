package com.raynaud.raynaudAttacksDetector.repository;

import com.raynaud.raynaudAttacksDetector.model.Participant;
import org.hibernate.boot.spi.SessionFactoryOptions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
public interface ParticipantsCollectionRepository extends JpaRepository<Participant, Long> {
    Optional<Participant> findByUuid(String uuid);

    Optional<Participant> findByUserName(String participantName);

}
