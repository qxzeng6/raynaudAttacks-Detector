package com.raynaud.raynaudAttacksDetector.repository;

import com.raynaud.raynaudAttacksDetector.model.Attacks;
import com.raynaud.raynaudAttacksDetector.model.Position;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public interface AttacksCollectionRepository extends JpaRepository<Attacks, Long> {

    List<Attacks> findByUserName(String participantName);

    default List<Attacks> findByUserNameWithin7Days(String participantName, LocalDate attackDate){
        return findByUserName(participantName).stream()
                .filter(attack -> attack.getAttackDate().isAfter(attackDate.minusDays(7)))
                .sorted(Comparator.comparing(Attacks::getAttackDate))
                .collect(Collectors.toList());
    }


}
