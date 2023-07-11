package com.ho.todoserver.common.entity;

import com.ho.todoserver.common.status.ResponseStatus;
import lombok.Getter;

@Getter
public class ApiResponseEntity<T> {
    private int statusCode;
    private String message;
    private T payload;

    public static <T> ApiResponseEntity<T> onSuccess(T payload) {
        return new ApiResponseEntity(ResponseStatus.OK.getStatusCode(), ResponseStatus.OK.getMessage(), payload);
    }

    public static ApiResponseEntity onSuccess() {
        return new ApiResponseEntity(ResponseStatus.OK.getStatusCode(), ResponseStatus.OK.getMessage());
    }

    public ApiResponseEntity(int statusCode, String message, T payload) {
        this.statusCode = statusCode;
        this.message = message;
        this.payload = payload;
    }

    public ApiResponseEntity(int statusCode, T payload) {
        this.statusCode = statusCode;
        this.payload = payload;
    }

    public ApiResponseEntity(int statusCode) {
        this.statusCode = statusCode;
    }
}
