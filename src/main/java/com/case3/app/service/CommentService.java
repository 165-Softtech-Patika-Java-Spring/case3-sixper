package com.case3.app.service;

import com.case3.app.converter.CommentMapper;
import com.case3.app.dto.CommentDto.CommentResponseDto;
import com.case3.app.dto.CommentDto.CommentSaveDto;
import com.case3.app.entity.Comment;
import com.case3.app.entity.User;
import com.case3.app.service.entityservice.CommentEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentEntityService commentEntityService;
    private final UserService userService;
    private final ProductService productService;

    public CommentResponseDto save(CommentSaveDto commentSaveDto) {

        Comment comment = CommentMapper.INSTANCE.convertToComment(commentSaveDto);

        comment = commentEntityService.save(comment);

        return CommentMapper.INSTANCE.convertToCommentResponseDto(comment);
    }

    public void delete(Long id) {

        Comment comment = commentEntityService.getByIdWithControl(id);

        commentEntityService.delete(comment);
    }

    public List<CommentResponseDto> findByUserId(Long userId) {

        String userName = userService.getByIdWithControl(userId).getUserName();

        List<Comment> commentList = commentEntityService.findCommentByUser(userId);

        List<CommentResponseDto> commentResponseDtoList;
        if(!commentList.isEmpty()){
            commentResponseDtoList = CommentMapper.INSTANCE.convertToCommentResponseDtoList(commentList);
        }else{
            throw new RuntimeException("User " + userName + " did not write any comment!");
        }

        return commentResponseDtoList;
    }

    public List<CommentResponseDto> findByProductId(Long productId){

        String productName = productService.findById(productId).getName();

        List<Comment> commentList = commentEntityService.findCommentByProductId(productId);

        List<CommentResponseDto> commentResponseDtoList;
        if(!commentList.isEmpty()){
            commentResponseDtoList = CommentMapper.INSTANCE.convertToCommentResponseDtoList(commentList);
        }else{
            throw new RuntimeException("Product " + productName + " has not received any comment!");
        }

        return commentResponseDtoList;
    }
}
