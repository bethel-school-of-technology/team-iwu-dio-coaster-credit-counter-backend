package com.danharding.finalproject.credits;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditsRepository extends JpaRepository<CreditsCoaster, Long> {
    CreditsCoaster findByCoasterName(String coaster);
    CreditsCoaster findByParkName(String park);
}
