package com.bwj.todo.controller;

import com.bwj.todo.dto.request.CreatePostRequest;
import com.bwj.todo.dto.request.UpdatePostReqeust;
import com.bwj.todo.dto.response.CreatePostResponse;
import com.bwj.todo.dto.response.DeletePostResponse;
import com.bwj.todo.dto.response.PostResponse;
import com.bwj.todo.service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/posts")
public class PostController {

    private final PostService postService;

    @PostMapping
    public ResponseEntity<CreatePostResponse> createPost(@Valid @RequestBody CreatePostRequest createPostRequest) {
        CreatePostResponse body = postService.createPost(createPostRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(body);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostResponse> getOne(@PathVariable Long id) {
        PostResponse body = postService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(body);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<PostResponse> updatePost(
            @PathVariable Long id,
            @RequestBody @Valid UpdatePostReqeust request) {

        PostResponse body = postService.updatePost(request, id);
        return ResponseEntity.status(HttpStatus.OK).body(body);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeletePostResponse> deletePost(@PathVariable Long id) {
        DeletePostResponse response = postService.deletePost(id);
        return ResponseEntity.ok(response);
    }

}
