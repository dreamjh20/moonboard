package com.moon.moonboard.domain.posts;

import com.moon.moonboard.MoonboardApplication;
import com.moon.moonboard.domain.posts.PostRepository;
import com.moon.moonboard.domain.posts.Posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MoonboardApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class PostRepositoryTest {

    @Autowired
    PostRepository postRepository;

    //After unit test
    @After
    public void cleanup() {
        //clear database
        postRepository.deleteAll();
    }

    @Test
    public void call_save_post() {
        String title = "Test Title";
        String content = "Test Content";

        //insert or update
        postRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author("moonboard@Gmail.com")
                .build());

        List<Posts> postsList = postRepository.findAll();

        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }

}
