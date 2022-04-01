package com.moon.moonboard.domain.posts;

import com.moon.moonboard.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Getter
@NoArgsConstructor

//will be linked with table
@Entity
//in Entity class never makes Setter method

public class Posts extends BaseTimeEntity {

    //primary key
    @Id
    //primary key rule
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    //make builder itself
    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void  update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}