package com.raynaud.raynaudAttacksDetector.controller;


import com.raynaud.raynaudAttacksDetector.model.Attacks;
import com.raynaud.raynaudAttacksDetector.model.Participant;
import com.raynaud.raynaudAttacksDetector.service.CliniciansCollectionServices;
import com.raynaud.raynaudAttacksDetector.service.ParticipantsCollectionServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clinicians")
@CrossOrigin(origins = {"*","http://localhost:4200"})
public class CliniciansListController {
    @Autowired
    private CliniciansCollectionServices cliniciansServices;
    @Autowired
    private ParticipantsCollectionServices participantService;

    @GetMapping("/listAll")
    public List<Participant> listAllParticipants() {
        return cliniciansServices.findAllParticipants();
    }
    @GetMapping("/{userName}")
    public List<Attacks> listAttackByTargetParticipants(@PathVariable String userName) {
        System.out.println(userName);
        return cliniciansServices.listAttackByTargetParticipants(userName);


    }



}
