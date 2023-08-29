package com.example.sessiontest.comment.model.service;

import com.example.sessiontest.comment.model.dto.CommentReq;
import com.example.sessiontest.comment.model.dto.CommentRes;
import com.example.sessiontest.comment.model.dto.CommentWriteReq;

import java.util.List;

public interface CommentService {
    void write(CommentWriteReq commentWriteReq);
    List<CommentRes> getCommentList(Long boardId);
}
