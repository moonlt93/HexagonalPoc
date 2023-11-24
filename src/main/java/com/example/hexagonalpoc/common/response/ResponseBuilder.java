package com.example.hexagonalpoc.common.response;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseBuilder {

    private ResponseBuilder() {}

    public static <T> Response<T> build(T data) {
        return new Response<>(true, data, null);
    }

    public static <T> Response<T> build(ErrorResponse errorResponse) {
        return new Response<>(false, null, errorResponse);
    }

    public static <T> ResponseEntity<Object> build(T data, HttpStatus status) {
        return ResponseEntity.status(status).body(ResponseBuilder.build(data));
    }

    public static ResponseEntity<Object> build(ErrorResponse errorResponse, HttpStatus status) {
        return ResponseEntity.status(status).body(ResponseBuilder.build(errorResponse));
    }
}
