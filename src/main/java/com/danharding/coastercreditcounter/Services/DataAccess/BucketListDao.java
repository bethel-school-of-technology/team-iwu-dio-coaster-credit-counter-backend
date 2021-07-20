package com.danharding.coastercreditcounter.Services.DataAccess;

import com.danharding.coastercreditcounter.Models.BucketListCoaster;

import java.util.List;
import java.util.Optional;

public interface BucketListDao {
    List<BucketListCoaster> findAll();
    Optional<BucketListCoaster> findById(long id);
    void delete(BucketListCoaster bucketListCoaster);

    BucketListCoaster save(BucketListCoaster newBucketListCoaster);
}
