package com.raynaud.raynaudAttacksDetector.service;


import com.raynaud.raynaudAttacksDetector.model.Participant;
import com.raynaud.raynaudAttacksDetector.repository.ParticipantsCollectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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


}
