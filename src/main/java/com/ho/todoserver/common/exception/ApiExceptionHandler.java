package com.ho.todoserver.common.exception;

import com.ho.todoserver.common.entity.ApiExceptionEntity;
import com.ho.todoserver.common.entity.ApiResponseEntity;
import com.ho.todoserver.common.status.ExceptionStatus;
import com.ho.todoserver.common.status.ResponseStatus;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.nio.file.AccessDeniedException;
import java.util.Iterator;

@RestControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler({ApiException.class})
    public ApiResponseEntity<ApiExceptionEntity> exceptionHandler(final ApiException e) {
        return new ApiResponseEntity(
                ResponseStatus.BAD_REQUEST.getStatusCode(),
                ResponseStatus.BAD_REQUEST.getMessage(),
                ApiExceptionEntity.builder()
                        .errorCode(e.getError().getCode())
                        .errorMessage(e.getError().getMessage())
                        .build()
        );
    }

    @ExceptionHandler({RuntimeException.class})
    public ApiResponseEntity<ApiExceptionEntity> exceptionHandler(final RuntimeException e) {
        e.printStackTrace();
        return new ApiResponseEntity(
                ResponseStatus.BAD_REQUEST.getStatusCode(),
                ResponseStatus.BAD_REQUEST.getMessage(),
                ApiExceptionEntity.builder()
                        .errorCode(ExceptionStatus.RUNTIME_EXCEPTION.getCode())
                        .errorMessage(e.getMessage())
                        .build()
        );
    }

    @ExceptionHandler({AccessDeniedException.class})
    public ApiResponseEntity<ApiExceptionEntity> exceptionHandler(final AccessDeniedException e) {
        e.printStackTrace();
        return new ApiResponseEntity(
                ResponseStatus.ACCESS_DENIED.getStatusCode(),
                ResponseStatus.ACCESS_DENIED.getMessage(),
                ApiExceptionEntity.builder()
                        .errorCode(ExceptionStatus.ACCESS_DENIED_EXCEPTION.getCode())
                        .errorMessage(e.getMessage())
                        .build()
        );
    }

    @ExceptionHandler({Exception.class})
    public ApiResponseEntity<ApiExceptionEntity> exceptionHandler(final Exception e) {
        e.printStackTrace();
        return new ApiResponseEntity(
                ResponseStatus.INTERNAL_SERVER_ERROR.getStatusCode(),
                ResponseStatus.INTERNAL_SERVER_ERROR.getMessage(),
                ApiExceptionEntity.builder()
                        .errorCode(ExceptionStatus.INTERNAL_SERVER_ERROR.getCode())
                        .errorMessage(e.getMessage())
                        .build()
        );
    }

    @ExceptionHandler({NoHandlerFoundException.class})
    public ApiResponseEntity<ApiExceptionEntity> exceptionHandler(final NoHandlerFoundException e) {
        e.printStackTrace();
        return new ApiResponseEntity(
                ResponseStatus.NOT_FOUND.getStatusCode(),
                ResponseStatus.NOT_FOUND.getMessage(),
                ApiExceptionEntity.builder()
                        .errorCode(ExceptionStatus.NOT_FOUND_EXCEPTION.getCode())
                        .errorMessage(e.getMessage())
                        .build()
        );
    }

    @ExceptionHandler({ConstraintViolationException.class})
    public ApiResponseEntity<ApiExceptionEntity> exceptionHandler(final ConstraintViolationException e) {
        e.printStackTrace();
        return new ApiResponseEntity(
                ResponseStatus.MISSING_REQUIRED_VALUES.getStatusCode(),
                ResponseStatus.MISSING_REQUIRED_VALUES.getMessage(),
                ApiExceptionEntity.builder()
                        .errorCode(ExceptionStatus.VALIDATION_FAIL.getCode())
                        .errorMessage(e.getConstraintViolations().iterator().next().getMessage())
//                        .errorMessage(getResultMessage(e.getConstraintViolations().iterator())
                        .build()
        );
    }

    /*protected String getResultMessage(final Iterator<ConstraintViolation<?>> violationIterator) {
        final StringBuilder resultMessageBuilder = new StringBuilder();
        while (violationIterator.hasNext() == true) {
            final ConstraintViolation<?> constraintViolation = violationIterator.next();
            resultMessageBuilder
                    .append(constraintViolation.getMessage()); // 유효성 검사 실패 시 메시지

            if (violationIterator.hasNext() == true) {
                resultMessageBuilder.append(", ");
            }
        }

        return resultMessageBuilder.toString();
    }

    protected String getPopertyName(String propertyPath) {
        return propertyPath.substring(propertyPath.lastIndexOf('.') + 1); // 전체 속성 경로에서 속성 이름만 가져온다.
    }*/
}
