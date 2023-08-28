package com.example.sessiontest.board.model.repository;

import com.example.sessiontest.board.model.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {

//    @Query("select b from Board b join fetch b.member")
//    @Override
//    List<Board> findAll();
}
