package com.kas.jareddit.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.Instant;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Username is required")
    private String username;

    @NotBlank(message = "Password is required")
    private String password;

    @Email
    @NotEmpty(message = "Email is required")
    private String email;

    private Instant created;

    private boolean enabled;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    @JsonBackReference(value = "subreddits")
    private List<Subreddit> subreddits;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    @JsonBackReference(value = "votes")
    private List<Vote> votes;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    @JsonBackReference(value = "posts")
    private List<Post> posts;

    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY)
    private VerificationToken token;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    @JsonBackReference(value = "comments")
    private List<Comment> comments;

}
