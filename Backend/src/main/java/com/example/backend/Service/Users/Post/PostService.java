package com.example.backend.Service.Users.Post;

import com.example.backend.Domain.Posts.Posts;
import com.example.backend.Domain.Posts.PostsRepository;
import com.example.backend.Web.DTO.PostsRequest;
import com.example.backend.Web.DTO.SignRequest;
import org.springframework.stereotype.Service;

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

}
