package com.raynaud.raynaudAttacksDetector.service;


import com.raynaud.raynaudAttacksDetector.model.Participant;
import com.raynaud.raynaudAttacksDetector.repository.ParticipantsCollectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParticipantsCollectionServices {
    @Autowired
    private ParticipantsCollectionRepository participantRepository;

    public Participant registerParticipant(String userName, String uuid) {
        System.out.println("Saving Participant");
        Participant participant = new Participant();
        participant.setUserName(userName);
        participant.setUuid(uuid);
        return participantRepository.save(participant);
    }

    public List<Participant> findAllParticipants() {
        return participantRepository.findAll();
    }

    public Optional<Participant> findParticipantByUuid(String uuid){
        return participantRepository.findByUuid(uuid);
    }
    public Optional<Participant> findParticipantByUseName(String userName){
        return participantRepository.findByUserName(userName);
    }


}
