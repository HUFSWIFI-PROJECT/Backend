package com.example.backend.Web;

import com.example.backend.Service.posts.PostsService;
import com.example.backend.Web.DTO.PostsResponseDto;
import com.example.backend.Web.DTO.PostsSaveRequestDto;
import com.example.backend.Web.DTO.PostsUpdateRequestDto;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    @Operation(summary = "게시글 등록", description = "게시글을 등록합니다.")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    @Operation(summary = "게시글 수정", description = "게시글을 수정합니다.")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    @Operation(summary = "게시글 조회", description = "게시글을 조회합니다.")
    public PostsResponseDto findById(@PathVariable Long id) {
        return postsService.findById(id);
    }

}
