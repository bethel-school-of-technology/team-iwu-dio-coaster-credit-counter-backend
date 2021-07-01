package com.danharding.finalproject.bucketList;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableWebSecurity
public class BucketListController {

    @Autowired
    BucketListRepository bucketListRepository;

    @PostMapping("coasters/bucketlist")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<String> addBucketListCoaster(@RequestBody BucketListCoaster newBucketListCoaster) {
        List<BucketListCoaster> bucketListCoasters = bucketListRepository.findAll();

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
            bucketListRepository.save(newBucketListCoaster);
            return ResponseEntity.ok("Coaster created successfully");
        }
    }
}