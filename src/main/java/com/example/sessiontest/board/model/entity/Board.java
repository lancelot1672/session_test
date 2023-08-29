package com.example.sessiontest.board.model.entity;

import com.example.sessiontest.comment.model.entity.Comment;
import com.example.sessiontest.member.model.entity.Member;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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

    @OneToMany(mappedBy = "board")
    private List<Comment> commentList = new ArrayList<>();

    @Builder
    public Board(Long id, String title, String description, Member member){
        this.id = id;
        this.title = title;
        this.description = description;
        this.member = member;
    }
}
