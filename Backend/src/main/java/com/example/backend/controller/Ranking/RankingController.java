package com.example.backend.controller.Ranking;

import com.example.backend.Domain.Ranking.Ranking;
import com.example.backend.Service.Ranking.RankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class RankingController {

    @Autowired
    private RankingService rankingService;


    @PostMapping("/increaseCnt")
    public void increaseCnt(@RequestParam String title) {
        rankingService.increaseCnt(title);
    }

    @GetMapping("/top5")
    public List<Ranking> getTop5Titles() {
        return rankingService.getTop5Titles();
    }
}
