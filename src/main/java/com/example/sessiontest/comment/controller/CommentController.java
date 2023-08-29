package com.example.sessiontest.comment.controller;

import com.example.sessiontest.comment.model.dto.CommentReq;
import com.example.sessiontest.comment.model.dto.CommentRes;
import com.example.sessiontest.comment.model.dto.CommentWriteReq;
import com.example.sessiontest.comment.model.service.CommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/comment")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @PostMapping
    public ResponseEntity<?> writeComment(HttpServletRequest request, @RequestBody CommentWriteReq commentWriteReq){
        commentService.write(commentWriteReq);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<?> getComments(@RequestParam Long boardId){
        List<CommentRes> commentList = commentService.getCommentList(boardId);
        return new ResponseEntity<List<CommentRes>>(commentList, HttpStatus.OK);
    }
}
