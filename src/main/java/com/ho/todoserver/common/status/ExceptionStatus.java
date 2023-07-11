package com.ho.todoserver.common.status;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ExceptionStatus {
    RUNTIME_EXCEPTION(HttpStatus.BAD_REQUEST, "-1"),
    NOT_FOUND_EXCEPTION(HttpStatus.NOT_FOUND, "-2", "페이지를 찾을 수 없습니다."),
    ACCESS_DENIED_EXCEPTION(HttpStatus.UNAUTHORIZED, "-3"),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "-4"),
    SECURITY_01(HttpStatus.UNAUTHORIZED, "-5", "권한이 없습니다."),
    LOGIN_FAILED_EXCEPTION(HttpStatus.BAD_REQUEST, "-6", "로그인에 실패했습니다."),
    MEMBER_CREATE_01(HttpStatus.BAD_REQUEST, "-7", "아이디 중복"),
    VALIDATION_FAIL(HttpStatus.BAD_REQUEST, "-8", "데이터 검증 오류"),
    ;


    private final HttpStatus status;
    private final String code;
    private String message;

    ExceptionStatus(HttpStatus status, String code) {
        this.status = status;
        this.code = code;
    }

    ExceptionStatus(HttpStatus status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }
}
