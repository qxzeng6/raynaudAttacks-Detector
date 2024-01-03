package com.raynaud.raynaudAttacksDetector.service;

import com.raynaud.raynaudAttacksDetector.model.Attacks;
import com.raynaud.raynaudAttacksDetector.model.Participant;
import com.raynaud.raynaudAttacksDetector.model.Position;
import com.raynaud.raynaudAttacksDetector.model.attackDto;
import com.raynaud.raynaudAttacksDetector.repository.AttacksCollectionRepository;
import com.raynaud.raynaudAttacksDetector.repository.ParticipantsCollectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Service
public class AttacksCollectionServices {
    @Autowired
    private AttacksCollectionRepository attacksRepository;
    @Autowired
    private ParticipantsCollectionRepository participantsRepository;

    public List<Attacks> findByUserName(String participantName){
        return attacksRepository.findByUserName(participantName);
    }
    public String reportAttack(String participantName, String participantUuid,attackDto attackDto) {

        Attacks newAttack = new Attacks();
        if (participantsRepository.findByUuid(participantUuid).isEmpty()){
            return "Participant Not Found";
        }
        else{
            Participant participant = participantsRepository.findByUuid(participantUuid).get();
            System.out.println(participant);
            participant.setLastAttackDate(LocalDateTime.now());
            participantsRepository.save(participant);
            newAttack.setUuid(participantsRepository.findByUuid(participantUuid).get().getUuid());
            newAttack.setUserName(participantName);

        }

        if (Objects.equals(attackDto.getPosition(), "outside")){
            newAttack.setLocation(Position.OUTSIDE);
        }
        else{
            newAttack.setLocation(Position.INSIDE);
        }
//        newAttack.setAttackDate(attackDto.getAttackDate());
        LocalDate date = LocalDate.now();
        newAttack.setAttackDate(date);
        System.out.println(newAttack);
        attacksRepository.save(newAttack);
        return "Attack Reported";
    }

    public List<Attacks> dailyReport(String userName) {
        System.out.println("daily report Attacks");
        if (participantsRepository.findByUserName(userName).isEmpty()){
            return Collections.emptyList();
        }
        else{
            String participantName = participantsRepository.findByUserName(userName).get().getUserName();
//            LocalDate todayDate = LocalDate.now();
            System.out.println(participantName);
            return attacksRepository.findByUserNameWithin7Days(participantName);
        }

    }
}
