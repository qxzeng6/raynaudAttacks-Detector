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
@CrossOrigin(origins = {"http://localhost:52740,","http://localhost:4200"},allowCredentials = "true")

public class ParticipantsAttackReportController {
    @Autowired
    private AttacksCollectionServices attacksService;
    @PostMapping("/report")
    public String reportAttack(@RequestBody attackDto attackDto) {
        System.out.println(attackDto.getUuid());
        System.out.println(attackDto.getUserName());
        return attacksService.reportAttack(attackDto.getUserName(), attackDto.getUuid(), attackDto);
    }

    @GetMapping("/dailyReport/{userName}")
    public List<Attacks> dailyReport(@PathVariable("userName") String userName) {
        System.out.println(userName);
        return attacksService.dailyReport(userName);
    }


}
