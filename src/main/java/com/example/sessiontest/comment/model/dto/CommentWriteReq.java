package com.example.sessiontest.comment.model.dto;

import com.example.sessiontest.board.model.entity.Board;
import com.example.sessiontest.comment.model.entity.Comment;
import com.example.sessiontest.member.model.entity.Member;
import lombok.Data;

@Data
public class CommentWriteReq {
    Long boardId;
    String memberId;
    String description;

    /**
     *  DTO -> Entity
     */
    public Comment toEntity(Member member, Board board){
        return Comment.builder()
                .member(member)
                .board(board)
                .description(this.description).build();
    }
}
