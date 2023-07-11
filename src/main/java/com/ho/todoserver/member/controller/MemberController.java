package com.ho.todoserver.member.controller;

import com.ho.todoserver.common.entity.ApiResponseEntity;
import com.ho.todoserver.member.dto.MemberDto;
import com.ho.todoserver.member.service.MemberService;
import lombok.RequiredArgsConstructor;
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
    @GetMapping("/sign-in")
    public ApiResponseEntity<MemberDto> signIn(@ModelAttribute MemberDto memberDto) {
        return ApiResponseEntity.onSuccess(memberService.signIn(memberDto));
    }

    /*
     * 회원가입
     * */
    @ResponseBody
    @PostMapping("/sign-up")
    public ApiResponseEntity signUp(@RequestBody MemberDto memberDto) {
        memberService.signUp(memberDto);
        return ApiResponseEntity.onSuccess();
    }

    /*
     * id 중복확인
     * */
    @ResponseBody
    @PostMapping("/id-check")
    public ApiResponseEntity<Map> idCheck(@RequestBody MemberDto memberDto) {
        return ApiResponseEntity.onSuccess(memberService.idCheck(memberDto.getLoginId()));
    }

}

