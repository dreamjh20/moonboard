package com.moon.moonboard.domain.posts;

import com.moon.moonboard.MoonboardApplication;

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
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    //After unit test
    @After
    public void cleanup() {
        //clear database
        postsRepository.deleteAll();
    }


}
