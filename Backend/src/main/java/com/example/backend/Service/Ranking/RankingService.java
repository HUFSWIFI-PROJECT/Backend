package com.example.backend.Service.Ranking;

import com.example.backend.Domain.Ranking.Ranking;
import com.example.backend.Domain.Ranking.RankingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RankingService {

    @Autowired
    private RankingRepository rankingRepository;

    public RankingService(RankingRepository rankingRepository) {
        this.rankingRepository = rankingRepository;
    }

    public Optional<Ranking> findByTitle(String title) {
        return rankingRepository.findByTitle(title);
    }

    // 조회수 increase 함수
    public void increaseCnt(String title) {
        Optional<Ranking> optionalRanking = rankingRepository.findByTitle(title);  // 타이틀 있는지 찾음

        if (optionalRanking.isPresent()) {  // 타이틀이 있으면
            Ranking ranking = optionalRanking.get();  // ranking 인스턴스
            ranking.setCnt(ranking.getCnt() + 1); // 조회수 1 증가
            rankingRepository.save(ranking);
        } else {  // 만약에 타이틀이 없으면
            Ranking newRanking = new Ranking(title);  // 새로운 ranking 객체 만듦
            newRanking.setCnt(1);  // 조회수
            rankingRepository.save(newRanking);
        }
    }

    public List<Ranking> getTop5Titles() {
        return rankingRepository.findTop5ByOrderByHitsDesc();
    }
}
