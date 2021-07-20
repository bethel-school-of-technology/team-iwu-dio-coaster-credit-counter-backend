package com.danharding.coastercreditcounter.Repositories;

import com.danharding.coastercreditcounter.Models.CreditsCoaster;
import com.danharding.coastercreditcounter.Services.DataAccess.CreditsDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //TODO: don't forget this cheese either... lolz
public class MySQLCreditsDao implements CreditsDao {

    private final CreditsRepository creditsRepository;

    public MySQLCreditsDao(CreditsRepository creditsRepository) {
        this.creditsRepository = creditsRepository;
    }

    @Override
    public List<CreditsCoaster> findAll() {
        return creditsRepository.findAll();
    }

    @Override
    public CreditsCoaster save(CreditsCoaster creditsCoaster) {
        return creditsRepository.save(creditsCoaster);
    }

}
