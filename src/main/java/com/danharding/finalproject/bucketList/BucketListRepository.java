package com.danharding.finalproject.bucketList;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BucketListRepository extends JpaRepository<BucketListCoaster, Long>{
    // BucketListCoaster findByCoasterName(String coaster);
    // BucketListCoaster findByParkName(String park);
}
