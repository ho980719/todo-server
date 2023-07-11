package com.ho.todoserver.common.status;

import lombok.Getter;

@Getter
public enum ResponseStatus {
    OK(200, "정상 처리 되었습니다."),
    BAD_REQUEST(400, "잘못된 요청입니다."),
    MISSING_REQUIRED_VALUES(400, "필수값 누락"),
    ACCESS_DENIED(403, "권한이 없습니다."),
    NOT_FOUND(404, "페이지를 찾을수 없습니다."),
    INTERNAL_SERVER_ERROR(500, "서버 오류입니다.");

    int statusCode;
    String message;
    ResponseStatus(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }
}
