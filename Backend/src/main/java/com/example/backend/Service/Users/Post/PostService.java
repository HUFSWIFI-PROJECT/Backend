package com.example.backend.Service.Users.Post;

import com.example.backend.Domain.Posts.Posts;
import com.example.backend.Domain.Posts.PostsRepository;
import com.example.backend.Web.DTO.PostsRequest;
import com.example.backend.Web.DTO.SignRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {

    private final PostsRepository postsRepository;

    public PostService(PostsRepository postsRepository) {
        this.postsRepository = postsRepository;
    }


    public boolean save(PostsRequest request) throws Exception {

        Posts posts = Posts.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .author(request.getAuthor())
                .build();

        postsRepository.save(posts);

        return true;
    }

    public Posts findById(Long id) {
        Posts n =  postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        n.setHits(n.getHits() + 1);
        postsRepository.save(n);
        return postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
    }

    public List<Posts> findAll() {
        return postsRepository.findAll();
    }

    public List<Posts> findOrderbyHit() {
        return postsRepository.findTop5ByOrderByHitsDesc();
    }

}
