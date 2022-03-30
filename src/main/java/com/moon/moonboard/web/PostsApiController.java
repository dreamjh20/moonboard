package com.moon.moonboard.web;

import com.moon.moonboard.domain.posts.Posts;
import com.moon.moonboard.domain.posts.PostsRepository;
import com.moon.moonboard.web.dto.PostsResponseDto;
import com.moon.moonboard.web.dto.PostsSaveRequestDto;
import com.moon.moonboard.service.posts.PostsService;
import com.moon.moonboard.web.dto.PostsUpdateRequestDto;

import lombok.RequiredArgsConstructor;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById (@PathVariable Long id)
    {
        return postsService.findById(id);
    }
}
