package com.kas.jareddit.service;

import com.kas.jareddit.dto.SubredditDto;
import com.kas.jareddit.exception.JARedditException;
import com.kas.jareddit.exception.SubredditNotFoundException;
import com.kas.jareddit.mapper.SubredditMapper;
import com.kas.jareddit.model.Subreddit;
import com.kas.jareddit.repository.SubredditRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.time.Instant.now;
import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
public class SubredditService {

    private final SubredditRepository subredditRepository;
    private final AuthService authService;
    private final SubredditMapper subredditMapper;

//    @Transactional
//    public SubredditDto save(SubredditDto subredditDto) {
//        Subreddit save = subredditRepository.save(subredditMapper.mapDtoToSubreddit(subredditDto));
//        subredditDto.setId(save.getId());
//        return subredditDto;
//    }

    @Transactional(readOnly = true)
    public List<SubredditDto> getAll() {
        return subredditRepository.findAll()
                .stream()
                .map(subredditMapper::mapSubredditToDto)
                .collect(toList());
    }

    public SubredditDto getSubreddit(Long id) {
        Subreddit subreddit = subredditRepository.findById(id)
                .orElseThrow(() -> new JARedditException("No subreddit found with ID " + id));
        return subredditMapper.mapSubredditToDto(subreddit);
    }

    @Transactional
    public SubredditDto save(SubredditDto subredditDto) {
        Subreddit subreddit = subredditRepository.save(mapToSubreddit(subredditDto));
        subredditDto.setId(subreddit.getId());
        return subredditDto;
    }
//
//    @Transactional(readOnly = true)
//    public List<SubredditDto> getAll() {
//        return subredditRepository.findAll()
//                .stream()
//                .map(this::mapToDto)
//                .collect(toList());
//    }
//
//    @Transactional(readOnly = true)
//    public SubredditDto getSubreddit(Long id) {
//        Subreddit subreddit = subredditRepository.findById(id)
//                .orElseThrow(() -> new SubredditNotFoundException("Subreddit not found with id " + id));
//        return mapToDto(subreddit);
//    }
//
//    private SubredditDto mapToDto(Subreddit subreddit) {
//        return SubredditDto.builder().name(subreddit.getName())
//                .id(subreddit.getId())
//                .numberOfPosts(subreddit.getPosts().size())
//                .build();
//    }
//
    private Subreddit mapToSubreddit(SubredditDto subredditDto) {
        return Subreddit.builder().name("/r/" + subredditDto.getName())
                .description(subredditDto.getDescription())
                .user(authService.getCurrentUser())
                .createdDate(now()).build();
    }
}
