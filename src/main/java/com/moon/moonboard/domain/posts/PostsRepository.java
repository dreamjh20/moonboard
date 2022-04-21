package com.moon.moonboard.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts, Long>{

    @Query("SELECT pst FROM Posts pst ORDER BY pst.id DESC")
    List<Posts> findAllDesc();
}