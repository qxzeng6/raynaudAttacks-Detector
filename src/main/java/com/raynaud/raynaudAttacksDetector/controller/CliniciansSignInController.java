package com.raynaud.raynaudAttacksDetector.controller;
import com.raynaud.raynaudAttacksDetector.model.ClinicianDto;
import com.raynaud.raynaudAttacksDetector.service.CliniciansCollectionServices;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clinicians")
@CrossOrigin(origins = {"http://localhost:52740,","http://localhost:4200"},allowCredentials = "true")

public class CliniciansSignInController {
    @Autowired
    private CliniciansCollectionServices cliniciansServices;

    @PostMapping(value = {"/signin","/register"})

    public String requestDivider(@RequestBody ClinicianDto clinicianDto, HttpServletRequest request) {
//        System.out.println("Request Divider");
//        System.out.println(request.getRequestURI());
        if (request.getRequestURI().equals("/clinicians/signin")) {
            return signInClinician(clinicianDto);
        }
        else if (request.getRequestURI().equals("/clinicians/register")) {
            return registerClinician(clinicianDto);
        }
        else {
            return "Invalid Request";
        }
    }

    public String registerClinician(ClinicianDto clinicianDto) {
        System.out.println("Registering Clinician");
        System.out.println(clinicianDto.getUserName());
        System.out.println(clinicianDto.getPassword());
        String res = cliniciansServices.saveClinicians(clinicianDto.getUserName(),clinicianDto.getPassword());
        System.out.println(res);
        return res;


    }

    public String signInClinician(ClinicianDto clinicianDto) {
        System.out.println(clinicianDto.getUserName());
        System.out.println(clinicianDto.getPassword());
        if (cliniciansServices.signInClinicians(clinicianDto.getUserName(),clinicianDto.getPassword())){
            System.out.println("Clinician Signed In");
            return "signIn successful";
        }
        else {
            System.out.println("Clinician Not Signed In");
            return "signIn unsuccessful";
        }

    }


}
