package com.danharding.finalproject.credits;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableWebSecurity
public class CreditsController extends WebSecurityConfigurerAdapter{
    private static final String CREATE_CREDIT_URL = "/coasters/credits";
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

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable().authorizeRequests().antMatchers(HttpMethod.POST, CREATE_CREDIT_URL)
                .permitAll().anyRequest().authenticated();
    }
}
