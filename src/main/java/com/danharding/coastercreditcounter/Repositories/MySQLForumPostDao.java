package com.danharding.coastercreditcounter.Repositories;

import com.danharding.coastercreditcounter.Models.ForumPost;
import com.danharding.coastercreditcounter.Services.DataAccess.ForumPostDao;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MySQLForumPostDao implements ForumPostDao {

    private final ForumPostRepository forumPostRepository;

    public MySQLForumPostDao(ForumPostRepository forumPostRepository) {
        this.forumPostRepository = forumPostRepository;
    }

    @Override
    public List<ForumPost> findAll() {
        return forumPostRepository.findAll();
    }

    @Override
    public ForumPost save(ForumPost forumPost) {
        return forumPostRepository.save(forumPost);
    }

    @Override
    public void delete(ForumPost forumPost) {

    }

    @Override
    public Optional<ForumPost> findById(Long forumPostId) {
        return Optional.empty();
    }
}
