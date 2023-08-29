package com.example.sessiontest.comment.model.repository;

import com.example.sessiontest.board.model.entity.Board;
import com.example.sessiontest.comment.model.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    @Query("SELECT c FROM Comment c WHERE c.board.id=:boardId")
    List<Comment> findAllByBoardId(Long boardId);
}
