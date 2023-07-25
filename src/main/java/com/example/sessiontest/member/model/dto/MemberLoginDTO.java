package com.example.sessiontest.member.model.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class MemberLoginDTO {
    private String id;
    private String password;
    private String name;
}
