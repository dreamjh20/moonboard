package com.moon.moonboard.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class HomeControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void load_Mainpage() {
        String body = this.restTemplate.getForObject("/", String.class);
        assertThat(body).contains("Web Service Starting With Spring Boot");
    }

    @Test
    public void load_posts_save() {
        String body = this.restTemplate.getForObject("/posts/save", String.class);
        assertThat(body).contains("Regist Posts");
    }

}
