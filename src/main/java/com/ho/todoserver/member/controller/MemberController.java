package com.ho.todoserver.member.controller;

import com.ho.todoserver.common.entity.ApiResponseEntity;
import com.ho.todoserver.common.status.ResponseStatus;
import com.ho.todoserver.member.dto.MemberDto;
import com.ho.todoserver.member.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/members")
public class MemberController {

    private final MemberService memberService;

    /*
     * 로그인
     * */
    @ResponseBody
    @GetMapping("/sign-in")
    public ApiResponseEntity<MemberDto> signIn(@RequestBody MemberDto memberDto) {
        return ApiResponseEntity.onSuccess(memberService.signIn(memberDto));
    }

    /*
     * id 중복확인
     * */
    @ResponseBody
    @PostMapping("/id-check")
    public ApiResponseEntity<Map> idCheck(@RequestBody MemberDto memberDto) {
        return ApiResponseEntity.onSuccess(memberService.idCheck(memberDto.getLoginId()));
    }

    /*
     * 회원가입
     * */
    @ResponseBody
    @PostMapping("/create")
    public ApiResponseEntity signUp(@RequestBody MemberDto memberDto) {
        memberService.save(memberDto);
        return ApiResponseEntity.onSuccess();
//        return memberService.findByLoginId(memberDto.getLoginId());
    }
}

