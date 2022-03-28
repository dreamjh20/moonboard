package com.moon.moonboard.service.posts;

import com.moon.moonboard.domain.posts.Posts;
import com.moon.moonboard.domain.posts.PostsRepository;
import com.moon.moonboard.web.dto.PostsResponseDto;
import com.moon.moonboard.web.dto.PostsSaveRequestDto;
import com.moon.moonboard.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//Constructor Injection
@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Post doesn't exist! id="+id));
        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public PostsResponseDto findById (Long id) {
        Posts entity = postsRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Post doesn't exist! id="+id));

        return new PostsResponseDto(entity);
    }
}
