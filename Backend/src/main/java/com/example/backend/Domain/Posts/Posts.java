package com.example.backend.Domain.Posts;

import com.example.backend.Domain.BasetimeEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.Builder;

@Entity
@Getter
@NoArgsConstructor
public class Posts extends BasetimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(length = 50000)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
}