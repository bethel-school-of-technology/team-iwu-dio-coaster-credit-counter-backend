package com.danharding.coastercreditcounter.Controllers;



import java.util.List;

import com.danharding.coastercreditcounter.Models.CreditsCoaster;

import com.danharding.coastercreditcounter.Services.DataAccess.CreditsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableWebSecurity
public class CreditsController{
    
    @Autowired
    private CreditsDao creditsDao;

    @GetMapping("/coasters/credits")
    public List<CreditsCoaster> getAllCoasters(){
        return creditsDao.findAll();
    }


    @PostMapping("/coasters/credits")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<String> addCreditsCoaster(@RequestBody CreditsCoaster newCreditsCoaster) {
        List<CreditsCoaster> creditsCoasters = creditsDao.findAll();

        System.out.println("New bucket list coaster " + newCreditsCoaster.toString());
        boolean exists = false;
        for (CreditsCoaster creditsCoaster : creditsCoasters) {
            System.out.println("New bucket list coaster " + newCreditsCoaster.toString());

            if (creditsCoaster.equals(newCreditsCoaster)) {
                exists = true;
                System.out.println("Coaster already entered!");
            }

        }

        if (exists) {
            return ResponseEntity.badRequest().body("Coaster already exists");
        } else {
            creditsDao.save(newCreditsCoaster);
            return ResponseEntity.ok("Coaster created successfully");
        }
    }
}
