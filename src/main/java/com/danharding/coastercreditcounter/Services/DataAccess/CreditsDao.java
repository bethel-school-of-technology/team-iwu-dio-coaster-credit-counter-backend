package com.danharding.coastercreditcounter.Services.DataAccess;

import com.danharding.coastercreditcounter.Models.CreditsCoaster;

import java.util.List;
import java.util.Optional;

public interface CreditsDao {
    List<CreditsCoaster> findAll();
    CreditsCoaster save(CreditsCoaster creditsCoaster);
    Optional<CreditsCoaster> findById(Long coasterId);
    void delete(CreditsCoaster creditsCoaster);
}
