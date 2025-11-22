package com.bwj.todo.service;

import com.bwj.todo.Repository.PostRepository;
import com.bwj.todo.domain.Post;
import com.bwj.todo.dto.request.CreatePostRequest;
import com.bwj.todo.dto.request.UpdatePostReqeust;
import com.bwj.todo.dto.response.CreatePostResponse;
import com.bwj.todo.dto.response.DeletePostResponse;
import com.bwj.todo.dto.response.PostResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public CreatePostResponse createPost(CreatePostRequest request) {
        validateRequest(request);
        Post post = buildPost(request);
        Post savedPost = save(post);

        return toResponse(savedPost);
    }

    @Transactional(readOnly = true)
    public PostResponse getById(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new NullPointerException("게시글을 찾을 수 없습니다."));
        return PostResponse.from(post);
    }

    @Transactional
    public PostResponse updatePost(UpdatePostReqeust request, Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new NullPointerException("게시글을 찾을 수 없습니다."));

        post.update(request.title(), request.content());
        postRepository.save(post);
        return PostResponse.from(post);
    }

    @Transactional
    public DeletePostResponse deletePost(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new NullPointerException("게시글을 찾을 수 없습니다."));

        postRepository.delete(post);

        return DeletePostResponse.of(id);
    }

    private Post save(Post post) {
        return postRepository.save(post);
    }

    private CreatePostResponse toResponse(Post post) {
        return CreatePostResponse.from(post);
    }

    private Post buildPost(CreatePostRequest request) {
        return Post.builder()
                .title(request.title())
                .content(request.content())
                .author(request.author())
                .build();
    }

    private void validateRequest(CreatePostRequest request) {

        if (request == null) {
            throw new IllegalArgumentException("요청이 null 일 수 없습니다.");
        }
    }

}
