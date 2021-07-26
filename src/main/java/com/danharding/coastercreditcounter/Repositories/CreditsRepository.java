package com.danharding.coastercreditcounter.Repositories;

import com.danharding.coastercreditcounter.Models.CreditsCoaster;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditsRepository extends JpaRepository<CreditsCoaster, Long> {
    
}
