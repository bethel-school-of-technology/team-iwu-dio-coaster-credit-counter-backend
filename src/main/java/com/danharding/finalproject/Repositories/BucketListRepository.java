package com.danharding.finalproject.Repositories;

import com.danharding.finalproject.Models.BucketListCoaster;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BucketListRepository extends JpaRepository<BucketListCoaster, Long>{
    // BucketListCoaster findByCoasterName(String coaster);
    // BucketListCoaster findByParkName(String park);
}
