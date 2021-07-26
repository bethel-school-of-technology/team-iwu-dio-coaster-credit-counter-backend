package com.danharding.coastercreditcounter.Services.DataAccess;

import com.danharding.coastercreditcounter.Models.ForumPost;

import java.util.List;
import java.util.Optional;

public interface ForumPostDao {
    List<ForumPost> findAll();
    ForumPost save(ForumPost forumPost);
    void delete (ForumPost forumPost);
    Optional<ForumPost> findById(Long forumPostId);
}
