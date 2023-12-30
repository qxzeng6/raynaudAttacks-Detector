package com.raynaud.raynaudAttacksDetector.service;


import com.raynaud.raynaudAttacksDetector.model.Clinicians;
import com.raynaud.raynaudAttacksDetector.repository.CliniciansCollectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CliniciansCollectionServices {

    @Autowired
    private CliniciansCollectionRepository cliniciansCollectionRepository;

    public List<Clinicians> findAllClinicians() {
        return cliniciansCollectionRepository.findAll();
    }

    public Boolean clinicianExists(String userName) {
    return cliniciansCollectionRepository.existsByUserName(userName);
    }

    public Clinicians saveClinicians(String userName, String password) {
        System.out.println("Saving Clinician");
        Clinicians clinicians = new Clinicians();
        clinicians.setUserName(userName);
//        String hashed = BCrypt.hashpw(password, BCrypt.gensalt());
        clinicians.setPassword(password);

        return cliniciansCollectionRepository.save(clinicians);
    }



}
