package com.raynaud.raynaudAttacksDetector.controller;

import com.raynaud.raynaudAttacksDetector.model.Attacks;
import com.raynaud.raynaudAttacksDetector.model.attackDto;
import com.raynaud.raynaudAttacksDetector.service.AttacksCollectionServices;
import com.raynaud.raynaudAttacksDetector.service.ParticipantsCollectionServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/participants")
@CrossOrigin(origins = "http://localhost:8080")

public class ParticipantsAttackReportController {
    @Autowired
    private AttacksCollectionServices attacksService;
    @PostMapping("/report")
    public String reportAttack(@RequestBody attackDto attackDto,@CookieValue(value = "participants", defaultValue = "notFound") String participantUuid) {
        System.out.println(participantUuid);
        return attacksService.reportAttack(attackDto,participantUuid);
    }

    @GetMapping("/dailyReport")
    public List<Attacks> dailyReport(@CookieValue(value = "participants", defaultValue = "notFound") String participantUuid) {
        System.out.println(participantUuid);
        return attacksService.dailyReport(participantUuid);
    }


}
