package com.danharding.coastercreditcounter.Controllers;

import java.util.List;
import java.util.Optional;

import com.danharding.coastercreditcounter.Models.BucketListCoaster;

import com.danharding.coastercreditcounter.Services.DataAccess.BucketListDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableWebSecurity
public class BucketListController {

    @Autowired
    private BucketListDao bucketListDao;

    @GetMapping("/coasters/bucketlist")
    public List<BucketListCoaster> getAllBucketListCoasters() {
        return bucketListDao.findAll();
    }

    @DeleteMapping("/coasters/bucketlist/{id}")
    public ResponseEntity<?> deleteBucketListCoaster(@PathVariable(value = "id") Long coasterId){
        Optional<BucketListCoaster> bucketListCoasterOptional = bucketListDao.findById(coasterId);
         bucketListCoasterOptional
                .ifPresent(b -> bucketListDao.delete(b));
                
            

            return ResponseEntity.ok().build();
    }

    @PostMapping("/coasters/bucketlist")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<String> addBucketListCoaster(@RequestBody BucketListCoaster newBucketListCoaster) {
        List<BucketListCoaster> bucketListCoasters = bucketListDao.findAll();

        System.out.println("New bucket list coaster " + newBucketListCoaster.getCoaster());
        boolean exists = false;
        for (BucketListCoaster bucketListCoaster : bucketListCoasters) {
            System.out.println("New bucket list coaster " + newBucketListCoaster.toString());

            if (bucketListCoaster.equals(newBucketListCoaster)) {
                exists = true;
                System.out.println("Coaster already entered!");
            }

        }
        if (exists) {
            return ResponseEntity.badRequest().body("Coaster already exists");
        } else {
            bucketListDao.save(newBucketListCoaster);
            return ResponseEntity.ok("Coaster created successfully");
        }
    }
}