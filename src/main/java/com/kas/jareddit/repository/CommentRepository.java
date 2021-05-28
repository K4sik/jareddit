package com.kas.jareddit.repository;

import com.kas.jareddit.model.Comment;
import com.kas.jareddit.model.Post;
import com.kas.jareddit.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findByPost(Post post);

    List<Comment> findAllByUser(User user);

}
