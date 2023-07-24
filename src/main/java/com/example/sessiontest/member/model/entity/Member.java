package com.example.sessiontest.member.model.entity;

import javax.persistence.*;

@Entity
public class Member {
    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;


    private String password;

    private String name;



}
