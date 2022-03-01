package com.case3.app.dto.CommentDto;

import lombok.Data;

@Data
public class CommentResponseDto {

    private Long id;
    private String comment;
    private Long userId;
    private Long productId;
}
