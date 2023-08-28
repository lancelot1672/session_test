package com.example.sessiontest.member.model.entity;

import com.example.sessiontest.board.model.entity.Board;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member {
    @Id
    @Column(name = "member_id")
    private String id;


    private String password;

    private String name;

    @OneToMany(mappedBy = "member")
    private List<Board> boardList = new ArrayList<>();;

}
