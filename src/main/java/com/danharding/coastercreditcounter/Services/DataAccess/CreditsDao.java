package com.danharding.coastercreditcounter.Services.DataAccess;

import com.danharding.coastercreditcounter.Models.CreditsCoaster;

import java.util.List;

public interface CreditsDao {
    List<CreditsCoaster> findAll();
    CreditsCoaster save(CreditsCoaster creditsCoaster);
}
