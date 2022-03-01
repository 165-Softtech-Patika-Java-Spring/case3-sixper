package com.case3.app.dto.CommentDto;


import lombok.Data;

@Data
public class CommentSaveDto {

    private String comment;
    private Long userId;
    private Long productId;

}


