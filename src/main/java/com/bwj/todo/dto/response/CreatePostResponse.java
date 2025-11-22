package com.bwj.todo.dto.response;

import com.bwj.todo.entity.Post;


import java.time.LocalDateTime;

public record CreatePostResponse(
        Long id,
        String title,
        String content,
        String author,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
    public static  CreatePostResponse from(Post post){
        return new CreatePostResponse(
                post.getId(),
                post.getTitle(),
                post.getContent(),
                post.getAuthor(),
                post.getCreatedAt(),
                post.getUpdatedAt()
        );
    }
}
