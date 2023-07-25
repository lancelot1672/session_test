package com.example.sessiontest.member.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class MemberJoinDTO {
    private String id;
    private String password;
    private String name;
}
