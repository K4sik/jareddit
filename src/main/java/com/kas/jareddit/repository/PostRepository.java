package com.kas.jareddit.repository;

import com.kas.jareddit.model.Post;
import com.kas.jareddit.model.Subreddit;
import com.kas.jareddit.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findAllBySubreddit(Subreddit subreddit);

    List<Post> findByUser(User user);

}
