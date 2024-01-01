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
@CrossOrigin(origins = "http://localhost:8080")
public class ParticipantsSignInController {
    @Autowired
    private ParticipantsCollectionServices participantService;

    @PostMapping("/register")

    public Optional<String> registerParticipant(@RequestBody ParticipantDto participantDto, HttpServletRequest request, HttpServletResponse response) {
        System.out.println(participantDto.getUserName());
        if (request.getCookies()== null) {
            System.out.println("Cookies are null");
            setCookie(response,participantDto);
            System.out.println("Set response cookie");
            String uuid =participantDto.getUuid();
            participantDto.setUuid(uuid);
            participantService.registerParticipant(participantDto.getUserName(), participantDto.getUuid());
            return participantDto.getUserName().describeConstable();
        }
        else {
            System.out.println("Cookies are not null");
            return readCookie("participants",request);

        }

    }
    public void setCookie(HttpServletResponse response, ParticipantDto participantDto) {
        // create a cookie
        System.out.println("Setting cookie");
        Cookie cookie = new Cookie("participants", (participantDto.getUuid()));
        cookie.setMaxAge(7 * 24 * 60 * 60); // expires in 7 days
        cookie.setSecure(true);
        cookie.setHttpOnly(true);
        cookie.setPath("/");
        //add cookie to response
        response.addCookie(cookie);

        return ;
    }

    public Optional<String> readCookie(String key,HttpServletRequest request) {
        System.out.println("Reading cookie");
        return Arrays.stream(request.getCookies())
                .filter(c -> key.equals(c.getName()))
                .map(Cookie::getValue)
                .findAny();
    }






}
