package com.example.sessiontest.board.model.service;

import com.example.sessiontest.board.model.dto.BoardReadRes;
import com.example.sessiontest.board.model.dto.BoardWriteReq;
import com.example.sessiontest.board.model.entity.Board;
import com.example.sessiontest.board.model.repository.BoardRepository;
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
public class BoardServiceImpl implements BoardService{
    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;
    @Override
    public void saveBoard(String userId, BoardWriteReq boardWriteReq) {
        Optional<Member> findMember = memberRepository.findById(userId);
        if(!findMember.isPresent()){
            log.error("회원 정보가 없습니다.");
        }

        Member member = findMember.get();
        Board board = Board.builder().title(boardWriteReq.getTitle())
                .description(boardWriteReq.getDescription())
                .member(member).build();
        boardRepository.save(board);
    }

    @Override
    public BoardReadRes readBoard(Long boardId) {
        Optional<Board> findBoard = boardRepository.findById(boardId);
        if(!findBoard.isPresent()){
            log.error("게시글 정보가 없습니다.");
        }
        Board board = findBoard.get();
        BoardReadRes boardReadRes = BoardReadRes.builder()
                .id(board.getId())
                .title(board.getTitle())
                .description(board.getDescription())
                .memberId(board.getMember().getId())
                .memberName(board.getMember().getName())
                .build();

        return boardReadRes;
    }

    @Override
    public List<BoardReadRes> findAllBoards() {
        List<Board> boardList = boardRepository.findAll();

        //Stream 사용
        List<BoardReadRes> resultList = boardList.stream()
                .map(board -> BoardReadRes.builder().id(board.getId())
                        .title(board.getTitle())
                        .description(board.getDescription())
                        .memberId(board.getMember().getId())
                        .memberName(board.getMember().getName()).build())
                .collect(Collectors.toList());
        return resultList;
    }
}
