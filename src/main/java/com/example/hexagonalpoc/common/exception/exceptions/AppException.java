package com.example.hexagonalpoc.common.exception.exceptions;


import com.example.hexagonalpoc.common.exception.ExceptionInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AppException extends RuntimeException {
    private final ExceptionInfo exceptionInfo;
}
