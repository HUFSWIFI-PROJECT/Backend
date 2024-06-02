package com.example.backend.Domain.Ranking;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface RankingRepository extends JpaRepository<Ranking, Long>{

    @Query("SELECT r FROM Ranking r WHERE r.title = :title")
    Optional<Ranking> findByTitle(String title);

    @Query("SELECT r FROM Ranking r ORDER BY r.cnt DESC")
    List<Ranking> findTop5ByOrderByHitsDesc();
}





