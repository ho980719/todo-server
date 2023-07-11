package com.ho.todoserver.common.exception;

import com.ho.todoserver.common.status.ExceptionStatus;
import lombok.Getter;

@Getter
public class ApiException extends RuntimeException {
    private ExceptionStatus error;

    public ApiException(ExceptionStatus e) {
        super(e.getMessage());
        this.error = e;
    }
}
