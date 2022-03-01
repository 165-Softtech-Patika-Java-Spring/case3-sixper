package com.case3.app.service.entityservice;

import com.case3.app.dao.CommentDao;
import com.case3.app.entity.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentEntityService {

    private final CommentDao commentDao;

    public Comment save(Comment comment){
        return commentDao.save(comment);
    }

    public void delete(Comment comment){
        commentDao.delete(comment);
    }

    private Optional<Comment> findById(Long id) {
        return commentDao.findById(id);
    }

    public Comment getByIdWithControl(Long id) {

        Optional<Comment> commentOptional = findById(id);

        Comment comment;
        if(commentOptional.isPresent()){
            comment = commentOptional.get();
        }else{
            throw new RuntimeException("Comment not found!");
        }

        return comment;
    }

    public List<Comment> findCommentByUser(Long userId){
        return commentDao.findByUserId(userId);
    }

    public List<Comment> findCommentByProductId(Long productId){
        return commentDao.findByProductId(productId);
    }
}
