package com.bwj.todo.dto.response;

public record DeletePostResponse(
        boolean success,
        String message,
        Long postId
) {
    public static DeletePostResponse of(Long postId) {
        return new DeletePostResponse(true, "게시글이 삭제 되었습니다.", postId);
    }
}
