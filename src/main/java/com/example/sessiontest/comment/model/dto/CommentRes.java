package com.example.sessiontest.comment.model.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class CommentRes {
    private Long id;
    private String description;
    private String memberId;
    private String memberName;
    private LocalDateTime createTime;
}
