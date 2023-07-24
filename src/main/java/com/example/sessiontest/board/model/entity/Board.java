package com.example.sessiontest.board.model.entity;

import com.example.sessiontest.member.model.entity.Member;

import javax.persistence.*;

@Entity
public class Board {
    @Id @GeneratedValue
    @Column(name = "board_id")
    private Long id;

    @Column
    private String title;

    @Column
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

}
