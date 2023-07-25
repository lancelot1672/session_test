package com.example.sessiontest.member.model.service;

import com.example.sessiontest.member.model.dto.MemberJoinDTO;
import com.example.sessiontest.member.model.dto.MemberLoginDTO;
import com.example.sessiontest.member.model.entity.Member;
import com.example.sessiontest.member.model.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{
    private final MemberRepository memberRepository;

    @Override
    public MemberLoginDTO login(MemberLoginDTO memberLoginDTO) {
        Optional<Member> findMember = memberRepository.findById(memberLoginDTO.getId());

        if(findMember.isEmpty()) return null;
        Member member = findMember.get();

        MemberLoginDTO memberDTO = MemberLoginDTO.builder()
                .id(member.getId())
                .name(member.getName())
                .build();

        return memberDTO;
    }

    @Override
    public void save(MemberJoinDTO memberJoinDTO) {
        Member member = new Member();

        member.setId(memberJoinDTO.getId());
        member.setPassword(memberJoinDTO.getPassword());
        member.setName(memberJoinDTO.getName());

        memberRepository.save(member);

    }

    @Override
    public MemberLoginDTO findUsername(String userId) {
        Optional<Member> findMember = memberRepository.findById(userId);

        if(findMember.isEmpty()) return null;
        Member member = findMember.get();

        MemberLoginDTO memberDTO = MemberLoginDTO.builder()
                .name(member.getName()).build();

        return memberDTO;
    }
}
