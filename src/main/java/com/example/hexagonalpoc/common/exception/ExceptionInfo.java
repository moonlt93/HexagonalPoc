package com.example.hexagonalpoc.common.exception;


import org.springframework.http.HttpStatus;

public interface ExceptionInfo {
    HttpStatus getHttpStatus();

    String getMessage();

    default String getCode() {
        return getHttpStatus().toString();
    }
}
