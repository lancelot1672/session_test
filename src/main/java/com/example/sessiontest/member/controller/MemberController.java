package com.example.sessiontest.member.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member")
public class MemberController {
    @GetMapping("/test")
    public ResponseEntity<String> test(){
        return new ResponseEntity<String>( "Success", HttpStatus.OK);
    }

}
