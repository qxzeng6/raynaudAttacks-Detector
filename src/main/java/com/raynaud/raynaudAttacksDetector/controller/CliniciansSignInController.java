package com.raynaud.raynaudAttacksDetector.controller;
import com.raynaud.raynaudAttacksDetector.model.ClinicianDto;
import com.raynaud.raynaudAttacksDetector.service.CliniciansCollectionServices;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clinicians")
@CrossOrigin(origins = "http://localhost:8080")

public class CliniciansSignInController {
    @Autowired
    private CliniciansCollectionServices cliniciansServices;

    @PostMapping({"/signin","/register"})

    public void requestDivider(@RequestBody ClinicianDto clinicianDto, HttpServletRequest request) {
//        System.out.println("Request Divider");
//        System.out.println(request.getRequestURI());
        if (request.getRequestURI().equals("/clinicians/signin")) {
            signInClinician(clinicianDto);
        }
        else if (request.getRequestURI().equals("/clinicians/register")) {
            registerClinician(clinicianDto);
        }
    }

    public void registerClinician(ClinicianDto clinicianDto) {
        System.out.println("Registering Clinician");
        System.out.println(clinicianDto.getUserName());
        System.out.println(clinicianDto.getPassword());
        cliniciansServices.saveClinicians(clinicianDto.getUserName(),clinicianDto.getPassword());

    }

    public Boolean signInClinician(ClinicianDto clinicianDto) {
        System.out.println(clinicianDto.getUserName());
        System.out.println(clinicianDto.getPassword());

        return true;
    }


}
