package com.danharding.coastercreditcounter.Repositories;

import com.danharding.coastercreditcounter.Models.Comment;
import com.danharding.coastercreditcounter.Services.DataAccess.CommentDao;

import java.util.List;
import java.util.Optional;

public class MySQLCommentDao implements CommentDao {

    private final CommentRepository commentRepository;

    public MySQLCommentDao(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    @Override
    public Comment save(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public void delete(Comment deleteComment) {
        commentRepository.delete(deleteComment);
    }

    @Override
    public Optional<Comment> findById(Long commentId) {
        return Optional.empty();
    }
}
