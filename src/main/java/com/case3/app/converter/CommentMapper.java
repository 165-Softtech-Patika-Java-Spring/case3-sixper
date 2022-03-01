package com.case3.app.converter;

import com.case3.app.dto.CommentDto.CommentResponseDto;
import com.case3.app.dto.CommentDto.CommentSaveDto;
import com.case3.app.entity.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CommentMapper {

    CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);

    Comment convertToComment(CommentSaveDto commentSaveDto);

    CommentResponseDto convertToCommentResponseDto(Comment comment);

    List<CommentResponseDto> convertToCommentResponseDtoList(List<Comment> commentList);
}
