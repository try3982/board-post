package com.bwj.todo.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreatePostRequest(

        @NotBlank(message ="제목은 필 수 입니다.")
        @Size(max = 20, message =" 제목은 20글자를 초과할 수 없습니다.")
        String title,

        @NotBlank(message= "내용을 입력해주세요.")
        @Size(max = 200, message= "내용은 필수 입니다.")
        String content,

        @NotBlank(message = "작성자는 필수입니다.")
        @Size(max = 10,message= "작성자명은 10글자를 초과할 수 없습니다.")
        String author
) {
}
