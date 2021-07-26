package com.danharding.coastercreditcounter.Controllers;


import com.danharding.coastercreditcounter.Models.Comment;
import com.danharding.coastercreditcounter.Repositories.MySQLCommentDao;
import com.danharding.coastercreditcounter.Services.DataAccess.CommentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@EnableWebSecurity
public class CommentController {

    @Autowired
    private CommentDao commentDao;

    @Autowired
    MySQLCommentDao mySQLCommentDao;

    @PostMapping("/comments")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<String> newComment (@RequestBody Comment newComment) {
        List<Comment> comments = commentDao.findAll();

        commentDao.save(newComment);
        return ResponseEntity.ok("Comment successfully created");
    }

    @GetMapping("/comments")
    public List<Comment> getAllComments() {
        return commentDao.findAll();
    }

    @DeleteMapping("comments/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<?> deleteComment(@PathVariable(value = "id") Long commentId) {
        Optional<Comment> commentOptional = commentDao.findById(commentId);
        commentOptional
                .ifPresent(b -> commentDao.delete(b));

        return ResponseEntity.ok().build();
    }
}
