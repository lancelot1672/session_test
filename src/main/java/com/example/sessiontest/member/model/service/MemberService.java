package com.example.sessiontest.member.model.service;

import com.example.sessiontest.member.model.dto.MemberJoinDTO;
import com.example.sessiontest.member.model.dto.MemberLoginDTO;


public interface MemberService {
    MemberLoginDTO login(MemberLoginDTO memberLoginDTO);
    void save(MemberJoinDTO memberJoinDTO);

    MemberLoginDTO findUsername(String userId);

}
