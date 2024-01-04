package com.raynaud.raynaudAttacksDetector.controller;


import com.raynaud.raynaudAttacksDetector.model.Participant;
import com.raynaud.raynaudAttacksDetector.model.ParticipantDto;
import com.raynaud.raynaudAttacksDetector.service.ParticipantsCollectionServices;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/participants")
@CrossOrigin(origins = {"*","http://localhost:4200"})

public class ParticipantsSignInController {
    @Autowired
    private ParticipantsCollectionServices participantService;

    @PostMapping("/register")

    public String registerParticipant(@RequestBody ParticipantDto participantDto, HttpServletRequest request, HttpServletResponse response) {
        System.out.println(participantDto.getUserName());
        if ( participantService.findParticipantByUseName(participantDto.getUserName()).isEmpty() &&participantService.findParticipantByUuid(participantDto.getUuid()).isEmpty()){
            participantService.registerParticipant(participantDto.getUserName(), participantDto.getUuid());
            return participantDto.getUserName();
        }
        else{
            return "Registration failed";
        }




    }





}
