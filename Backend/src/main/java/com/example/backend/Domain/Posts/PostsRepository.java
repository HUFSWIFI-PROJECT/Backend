package com.example.backend.Domain.Posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PostsRepository  extends JpaRepository<Posts, Long> {
    Optional<Posts> findById(Long id);

    List<Posts> findAll();

    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();

    @Query("SELECT p FROM Posts p ORDER BY p.hits DESC")
    List<Posts> findTop5ByOrderByHitsDesc();


}