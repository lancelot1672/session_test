package com.example.sessiontest.board.model.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class BoardReadRes {
    private Long id;
    private String title;
    private String description;
    private String memberId;
    private String memberName;
}
