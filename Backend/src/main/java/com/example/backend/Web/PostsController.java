package com.example.backend.Web;

import com.example.backend.Service.Users.EmailService;
import com.example.backend.Service.Users.Post.PostService;
import com.example.backend.Service.Users.SignService;
import com.example.backend.Web.DTO.PostsRequest;
import com.example.backend.Web.DTO.SignRequest;
import com.example.backend.Web.DTO.SignResponse;
import com.example.backend.unit.OAuthService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class PostsController {

    private final PostService postService;

    @Operation(operationId = "save", summary = "게시글 저장", description = "게시글 저장", tags = "PostsController")
    @PostMapping(value = "/save")
    public ResponseEntity<Boolean> save(@RequestBody PostsRequest request) throws Exception {
        return new ResponseEntity<>(postService.save(request), HttpStatus.OK);
    }
}
