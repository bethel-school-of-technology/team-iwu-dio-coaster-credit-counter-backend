package com.danharding.finalproject.Repositories;

import com.danharding.finalproject.Models.CreditsCoaster;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditsRepository extends JpaRepository<CreditsCoaster, Long> {
    
}
