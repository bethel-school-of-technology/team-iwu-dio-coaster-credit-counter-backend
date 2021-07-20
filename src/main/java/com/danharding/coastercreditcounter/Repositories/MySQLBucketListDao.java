package com.danharding.coastercreditcounter.Repositories;

import com.danharding.coastercreditcounter.Models.BucketListCoaster;
import com.danharding.coastercreditcounter.Services.DataAccess.BucketListDao;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service //TODO: please.... stop adding this cheese....lolz
public class MySQLBucketListDao implements BucketListDao {

    private final BucketListRepository bucketListRepository;

    public MySQLBucketListDao(BucketListRepository bucketListRepository) {
        this.bucketListRepository = bucketListRepository;
    }

    @Override
    public List<BucketListCoaster> findAll() {
        return bucketListRepository.findAll();
    }

    @Override
    public Optional<BucketListCoaster> findById(long id) {
        return bucketListRepository.findById(id);
    }

    @Override
    public void delete(BucketListCoaster bucketListCoaster) {
        bucketListRepository.delete(bucketListCoaster);
    }

    @Override
    public BucketListCoaster save(BucketListCoaster newBucketListCoaster) {
        return bucketListRepository.save(newBucketListCoaster);
    }

}
