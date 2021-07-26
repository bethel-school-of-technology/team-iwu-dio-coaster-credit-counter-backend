package com.danharding.coastercreditcounter.Services.DataAccess;

import com.danharding.coastercreditcounter.Models.Comment;

import java.util.List;
import java.util.Optional;

public interface CommentDao {
    List<Comment> findAll();
    Comment save (Comment comment);
    void delete (Comment comment);
    Optional<Comment> findById(Long commentId);
}
