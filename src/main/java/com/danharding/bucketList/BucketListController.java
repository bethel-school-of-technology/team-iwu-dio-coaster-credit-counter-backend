package com.danharding.bucketList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BucketListController {
    @Autowired
    BucketListRepository bucketListRepository;
}