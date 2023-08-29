package com.example.sessiontest.comment.model.entity;

import com.example.sessiontest.board.model.entity.Board;
import com.example.sessiontest.member.model.entity.Member;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment {
    @Id
    @GeneratedValue
    @Column(name = "comment_id")
    private Long id;

    @Column
    private String description;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;

    @Column
    private LocalDateTime writeDate;

    @Builder
    public Comment(Long id, String description, Member member, Board board, LocalDateTime writeDate) {
        this.id = id;
        this.description = description;
        this.member = member;
        this.board = board;
        this.writeDate = writeDate;
    }
}
