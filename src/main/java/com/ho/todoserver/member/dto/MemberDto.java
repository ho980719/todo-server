package com.ho.todoserver.member.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@AllArgsConstructor
@Data
public class MemberDto {
    private Long id;
    private String loginId;
    private String name;
    private String password;

}
