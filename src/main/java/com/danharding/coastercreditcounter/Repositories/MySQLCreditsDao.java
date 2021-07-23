package com.danharding.coastercreditcounter.Repositories;

import com.danharding.coastercreditcounter.Models.CreditsCoaster;
import com.danharding.coastercreditcounter.Services.DataAccess.CreditsDao;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Optional<CreditsCoaster> findById(Long coasterId) {
        return creditsRepository.findById(coasterId);
    }

    @Override
    public void delete(CreditsCoaster creditsCoaster) {

    }

}
