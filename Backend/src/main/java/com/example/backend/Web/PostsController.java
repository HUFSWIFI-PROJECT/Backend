package com.example.backend.Web;

import com.example.backend.Domain.Posts.Posts;
import com.example.backend.Service.Users.EmailService;
import com.example.backend.Service.Users.Post.PostService;
import com.example.backend.Service.Users.SignService;
import com.example.backend.Web.DTO.PostsRequest;
import com.example.backend.Web.DTO.SignRequest;
import com.example.backend.Web.DTO.SignResponse;
import com.example.backend.unit.OAuthService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostsController {

    @Autowired
    private final PostService postService;

    @Operation(operationId = "save", summary = "게시글 저장", description = "게시글 저장", tags = "PostsController")
    @PostMapping(value = "/save")
    public ResponseEntity<Boolean> save(@RequestBody PostsRequest request) throws Exception {
        return new ResponseEntity<>(postService.save(request), HttpStatus.OK);
    }

    @Operation(operationId = "findbyid", summary = "findbyid", description = "findbyid", tags = "PostsController")
    @GetMapping(value = "/findbyid")
    public ResponseEntity<Posts> findById(@RequestParam Long id) {


        return new ResponseEntity<>(postService.findById(id), HttpStatus.OK);
    }

    @Operation(operationId = "findbyall", summary = "테스트", description = "테스트", tags = "PostsController")
    @GetMapping(value = "/findbyall")
    public ResponseEntity<List<Posts>> findAll() {
        return new ResponseEntity<>(postService.findAll(), HttpStatus.OK);
    }

    @Operation(operationId = "findOrderbyHit", summary = "hit정렬", description = "테스트", tags = "PostsController")
    @GetMapping(value = "/findOrderbyHit")
    public ResponseEntity<List<Posts>> findOrderbyHit() {
        return new ResponseEntity<>(postService.findOrderbyHit(), HttpStatus.OK);
    }

}
