package com.example.sessiontest.comment.model.service;

import com.example.sessiontest.board.model.entity.Board;
import com.example.sessiontest.board.model.repository.BoardRepository;
import com.example.sessiontest.comment.model.dto.CommentReq;
import com.example.sessiontest.comment.model.dto.CommentRes;
import com.example.sessiontest.comment.model.dto.CommentWriteReq;
import com.example.sessiontest.comment.model.entity.Comment;
import com.example.sessiontest.comment.model.repository.CommentRepository;
import com.example.sessiontest.member.model.entity.Member;
import com.example.sessiontest.member.model.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService{
    private final CommentRepository commentRepository;
    private final MemberRepository memberRepository;
    private final BoardRepository boardRepository;
    @Override
    public void write(CommentWriteReq commentWriteReq) {
        Optional<Board> findBoard = boardRepository.findById(commentWriteReq.getBoardId());
        Optional<Member> findMember = memberRepository.findById(commentWriteReq.getMemberId());

        Board board = findBoard.get();
        Member member = findMember.get();

        Comment comment = commentWriteReq.toEntity(member, board);
        commentRepository.save(comment);
    }

    @Override
    public List<CommentRes> getCommentList(Long boardId) {
        log.info("boardId : {}", boardId);
//        Optional<Board> findBoard = boardRepository.findById(boardId);
        List<Comment> comments = commentRepository.findAllByBoardId(boardId);

        List<CommentRes> resultList = comments.stream()
                .map(comment -> CommentRes.builder()
                        .id(comment.getId())
                        .description(comment.getDescription())
                        .memberName(comment.getMember().getName())
                        .memberId(comment.getMember().getId()).build())
                .collect(Collectors.toList());
        return resultList;
    }
}
