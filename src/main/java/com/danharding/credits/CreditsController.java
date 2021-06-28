package com.danharding.credits;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreditsController {
    @Autowired
    CreditsRepository creditsRepository;



    @PostMapping("coasters/credits")
    @CrossOrigin(origins = "http://localhost:3000")
       public void addCreditsCoaster(CreditsCoaster newCreditsCoaster) {
        List<CreditsCoaster> creditsCoasters = creditsRepository.findAll();

        System.out.println("New bucket list coaster " + newCreditsCoaster.toString());

        for (CreditsCoaster creditsCoaster : creditsCoasters) {
            System.out.println("New bucket list coaster " + newCreditsCoaster.toString());
            
            if (creditsCoaster.equals(newCreditsCoaster)) {
                System.out.println("Coaster already entered!");
            }

            creditsRepository.save(newCreditsCoaster);
        }
    }
}
