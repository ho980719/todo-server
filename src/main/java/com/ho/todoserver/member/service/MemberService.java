package com.ho.todoserver.member.service;

import com.ho.todoserver.common.exception.ApiException;
import com.ho.todoserver.common.status.ExceptionStatus;
import com.ho.todoserver.member.dto.MemberDto;
import com.ho.todoserver.member.entity.Member;
import com.ho.todoserver.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberDto signIn(MemberDto memberDto) {
        return memberRepository.findByLoginIdAndPassword(memberDto.getLoginId(), memberDto.getPassword()).orElseThrow(()
                -> new ApiException(ExceptionStatus.LOGIN_FAILED_EXCEPTION));
    }

    public Map idCheck(String loginId) {
        Long count = memberRepository.countByLoginId(loginId);
        Map<String, Long> resultMap = new HashMap();
        resultMap.put("count", count);
        return resultMap;
    }

    public void save(MemberDto memberDto) {
        Long count = memberRepository.countByLoginId(memberDto.getLoginId());
        if (count > 0)
            throw new ApiException(ExceptionStatus.MEMBER_CREATE_01);

        Member member = Member.builder()
                .loginId(memberDto.getLoginId())
                .name(memberDto.getName())
                .password(memberDto.getPassword())
                .build();

        memberRepository.save(member);
    }

}
