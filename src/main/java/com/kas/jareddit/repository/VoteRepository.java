package com.kas.jareddit.repository;

import com.kas.jareddit.model.Post;
import com.kas.jareddit.model.User;
import com.kas.jareddit.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Long> {

    Optional<Vote> findTopByPostAndUserOrderByIdDesc(Post post, User user);

}


