package com.ssafy.chulcheck.member.controller;

import com.ssafy.chulcheck.member.model.MemberDto;
import com.ssafy.chulcheck.member.model.service.MemberService;
import com.ssafy.chulcheck.response.model.ResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
@Tag(name = "MemberController", description = "유저 컨트롤러")
public class MemberController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/test")
    @Operation(operationId = "test", summary = "테스트용", description = "테스트를 합니다.", tags = {"MemberController"})
    public ResponseEntity<?> test(){
        String s = "테스트 중 입니다.";
        return new ResponseEntity<String>(s, HttpStatus.OK);
    }

    @PostMapping("/join")
    @Operation(operationId = "join", summary = "회원가입", description = "회원가입을 합니다.", tags = {"MemberController"})
    public ResponseEntity<ResponseDto> join(@RequestBody MemberDto memberDto) throws Exception{
        ResponseDto response = new ResponseDto();
        if(memberService.join(memberDto) > 0){ // 성공한 경우
            response.setCode(1000);
            response.setMsg("회원가입 성공!!");
        } else {
            response.setCode(2000);
            response.setMsg("회원가입에 실패!!");
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/idcheck/{userId}")
    @Operation(operationId = "idcheck", summary = "아이디 중복체크", description = "아이디 중복 여부를 확인합니다.", tags = {"MemberController"})
    public ResponseEntity<ResponseDto> idCheck(@PathVariable String userId) throws Exception{
        ResponseDto response = new ResponseDto();
        logger.debug("아이디 체크중!!");
        if(memberService.idCheck(userId) > 0){ // 중복되는 경우
            response.setCode(2001);
            response.setMsg("이미 존재하는 아이디입니다.");
        } else{
            response.setCode(1001);
            response.setMsg("사용가능한 아이디입니다.");
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
