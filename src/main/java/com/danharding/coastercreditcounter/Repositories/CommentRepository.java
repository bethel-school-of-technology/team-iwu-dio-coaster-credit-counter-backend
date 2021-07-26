package com.danharding.coastercreditcounter.Repositories;

import com.danharding.coastercreditcounter.Models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Long> {
}
