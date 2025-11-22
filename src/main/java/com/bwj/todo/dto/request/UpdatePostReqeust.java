package com.bwj.todo.dto.request;

import jakarta.validation.constraints.Size;

public record UpdatePostReqeust(
        @Size(max = 20, message = "제목은 20글자를 초과할 수 없습니다.")
        String title,

        @Size(min = 1, max = 20, message = "내용은 최대 100자까지 입력할 수 있습니다.")
        String content
) {
}
