package com.example.sessiontest.board.model.service;

import com.example.sessiontest.board.model.dto.BoardReadRes;
import com.example.sessiontest.board.model.dto.BoardWriteReq;

import java.util.List;


public interface BoardService {
    void saveBoard(String userId, BoardWriteReq boardWriteReq);
    BoardReadRes readBoard(Long boardId);
    List<BoardReadRes> findAllBoards();
}
