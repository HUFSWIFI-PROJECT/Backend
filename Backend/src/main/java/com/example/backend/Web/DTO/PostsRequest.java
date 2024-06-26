package com.example.backend.Web.DTO;

import lombok.Setter;

@Setter
public class PostsRequest {
    private String title;
    private String content;
    private String author;

    public PostsRequest(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public PostsRequest() {

    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getAuthor() {
        return author;
    }
}
