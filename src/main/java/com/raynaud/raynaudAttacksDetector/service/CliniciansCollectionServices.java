package com.raynaud.raynaudAttacksDetector.service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.raynaud.raynaudAttacksDetector.model.Attacks;
import com.raynaud.raynaudAttacksDetector.model.Clinicians;
import com.raynaud.raynaudAttacksDetector.model.Participant;
import com.raynaud.raynaudAttacksDetector.repository.AttacksCollectionRepository;
import com.raynaud.raynaudAttacksDetector.repository.CliniciansCollectionRepository;
import com.raynaud.raynaudAttacksDetector.repository.ParticipantsCollectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class CliniciansCollectionServices {

    @Autowired
    private CliniciansCollectionRepository cliniciansCollectionRepository;
    @Autowired
    private ParticipantsCollectionRepository participantRepository;
    @Autowired
    private AttacksCollectionRepository attacksRepository;


    public List<Clinicians> findAllClinicians() {
        return cliniciansCollectionRepository.findAll();
    }

    public Boolean clinicianExists(String userName) {
    return cliniciansCollectionRepository.existsByUserName(userName);
    }

    public String saveClinicians(String userName, String password) {
        System.out.println("Saving Clinician");
        if (cliniciansCollectionRepository.existsByUserName(userName)){
            System.out.println("userName is exist");
            return "Clinician Unsaved";
        }
        else{
        Clinicians clinicians = new Clinicians();
        clinicians.setUserName(userName);
//        String hashed = BCrypt.hashpw(password, BCrypt.gensalt());
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password);
        clinicians.setPassword(hashedPassword);
        cliniciansCollectionRepository.save(clinicians);
        return "Clinician Saved";
        }
    }


    public boolean signInClinicians(String userName, String password) {
        System.out.println("Signing In Clinician");
        System.out.println(userName);
        System.out.println(password);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return cliniciansCollectionRepository.findByUserName(userName)
                .map(clinician -> passwordEncoder.matches(password, clinician.getPassword()))
                .orElse(false);
    }

    public List<Participant> findAllParticipants() {
        List<Participant> participants = participantRepository.findAll();
        Comparator<Participant> byLastAttackDate = Comparator
                .comparing(Participant::getLastAttackDate, Comparator.nullsLast(Comparator.naturalOrder()));

        participants.sort(byLastAttackDate);
        return participants;

    }


    public List<Attacks> listAttackByTargetParticipants(String userName) {
        System.out.println("Listing Target Participant's Attacks");
        if (attacksRepository.findByUserName(userName).isEmpty()){
            return Collections.emptyList();
        }
        else{
            return attacksRepository.findByUserName(userName);
        }
    }
}
