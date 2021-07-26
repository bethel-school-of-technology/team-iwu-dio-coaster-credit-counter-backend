package com.danharding.coastercreditcounter.Controllers;


import com.danharding.coastercreditcounter.Models.ForumPost;
import com.danharding.coastercreditcounter.Repositories.MySQLForumPostDao;
import com.danharding.coastercreditcounter.Services.DataAccess.ForumPostDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@EnableWebSecurity
public class ForumPostController {

    @Autowired
    private ForumPostDao forumPostDao;

    @Autowired
    MySQLForumPostDao mySQLForumPostDao;

    @PostMapping("/posts")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<String> newPost (@RequestBody ForumPost newForumPost) {
        List<ForumPost> forumPost = forumPostDao.findAll();

        forumPostDao.save(newForumPost);
        return ResponseEntity.ok("Post successfully created");
    }

    @GetMapping("/posts")
    public List<ForumPost> getAllForumPosts() {
        return forumPostDao.findAll();
    }

    @DeleteMapping("posts/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<?> deleteForumPost(@PathVariable(value = "id") Long forumPostId) {
        Optional<ForumPost> forumPostOptional = forumPostDao.findById(forumPostId);
        forumPostOptional
                .ifPresent(b -> forumPostDao.delete(b));

        return ResponseEntity.ok().build();
    }
}
