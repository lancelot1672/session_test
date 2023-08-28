package com.example.sessiontest.board.controller;

import com.example.sessiontest.board.model.dto.BoardReadRes;
import com.example.sessiontest.board.model.dto.BoardWriteReq;
import com.example.sessiontest.board.model.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;
    @GetMapping("/{boardId}")
    public ResponseEntity<?> boardRead(@PathVariable Long boardId){
        BoardReadRes board = boardService.readBoard(boardId);
        return new ResponseEntity<BoardReadRes>(board, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> boardWrite(HttpServletRequest request, @RequestBody BoardWriteReq boardWriteReq){
        HttpSession session = request.getSession(false);

        if(session.getAttribute("userId") != null){
            log.warn(">> Login Session 정보가 없습니다.");
        }
        String userId = (String) session.getAttribute("userId");
        boardService.saveBoard(userId, boardWriteReq);

        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/list")
    public ResponseEntity<?> getBoards(){
        List<BoardReadRes> boardList = boardService.findAllBoards();

        return new ResponseEntity<List<BoardReadRes>>(boardList, HttpStatus.OK);
    }
}
