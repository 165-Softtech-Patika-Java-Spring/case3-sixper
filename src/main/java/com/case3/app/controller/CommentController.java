package com.case3.app.controller;


import com.case3.app.dto.CommentDto.CommentResponseDto;
import com.case3.app.dto.CommentDto.CommentSaveDto;
import com.case3.app.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping
    public ResponseEntity save(@RequestBody CommentSaveDto commentSaveDto){

        CommentResponseDto commentResponseDto = commentService.save(commentSaveDto);

        return ResponseEntity.ok(commentResponseDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){

        commentService.delete(id);

        return ResponseEntity.ok(Void.TYPE);
    }

    @GetMapping("/userId/{userId}")
    public ResponseEntity findByUserId(@PathVariable Long userId){

        List<CommentResponseDto> commentResponseDtoList = commentService.findByUserId(userId);

        return ResponseEntity.ok(commentResponseDtoList);
    }

    @GetMapping("/productId/{productId}")
    public ResponseEntity findByProductId(@PathVariable Long productId){

        List<CommentResponseDto> commentResponseDtoList = commentService.findByProductId(productId);

        return ResponseEntity.ok(commentResponseDtoList);
    }
}
