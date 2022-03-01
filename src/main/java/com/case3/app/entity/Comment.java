package com.case3.app.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "COMMENT")
@Data
public class Comment {

    @Id
    @GeneratedValue(generator = "Comment")
    @SequenceGenerator(name = "Comment", sequenceName = "COMMENT_ID_SEQ")
    private Long id;

    @Column(name = "COMMENT", length = 200, nullable = false)
    private String comment;

    @Column(name = "ID_USER")
    private Long userId;

    @Column(name = "ID_PRODUCT")
    private Long productId;
}
