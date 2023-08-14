package com.example.sessiontest.member.controller;

import com.example.sessiontest.member.model.dto.MemberJoinDTO;
import com.example.sessiontest.member.model.dto.MemberLoginDTO;
import com.example.sessiontest.member.model.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j
@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/test")
    public ResponseEntity<String> test(HttpServletRequest request){
        return new ResponseEntity<String>( "Success", HttpStatus.OK);
    }

    @GetMapping("/login")
    public ResponseEntity<?> login(HttpServletRequest request, @RequestParam String id, @RequestParam String password){

        MemberLoginDTO memberLoginDTO = MemberLoginDTO.builder().id(id).password(password).build();

        // Session 로그인
        HttpSession session = request.getSession(true);

        if(session == null){
            log.debug(">> login 정보가 없습니다. 로그인 진행");
        }
        MemberLoginDTO login = memberService.login(memberLoginDTO);
        log.debug(">> Login User Info : {}", login.toString());

        session.setAttribute("userId", login.getId());
        session.setMaxInactiveInterval(1800);

        return new ResponseEntity<String>("login Success", HttpStatus.OK);
    }
    @GetMapping("/join")
    public ResponseEntity<?> join(HttpServletRequest request, @RequestParam String id, @RequestParam String password, @RequestParam String name){

        MemberJoinDTO memberJoinDTO = MemberJoinDTO.builder()
                .id(id)
                .password(password)
                .name(name).build();
        memberService.save(memberJoinDTO);

        return new ResponseEntity<String>("Join Success", HttpStatus.OK);
    }
    @GetMapping("/logout")
    public ResponseEntity<?> logout(HttpServletRequest request){
        //Session 만료
        HttpSession session = request.getSession(false);

        if(session == null){
            log.debug(">> login 정보가 없습니다. 로그아웃 진행");
        }

        session.invalidate();

        return new ResponseEntity<String>("logout Success", HttpStatus.OK);
    }
    @GetMapping("/user")
    public ResponseEntity<String> findUsername(HttpServletRequest request){
        HttpSession session = request.getSession(false);


        if(session.getAttribute("userId") != null){
            log.warn(">> Login Session 정보가 없습니다.");
        }
        String userId = (String) session.getAttribute("userId");
        log.debug(">> Session에 저장된 UserId : {}", userId);

        MemberLoginDTO memberLoginDTO = memberService.findUsername(userId);

        return new ResponseEntity<String>(memberLoginDTO.getName(), HttpStatus.OK);
    }

}
