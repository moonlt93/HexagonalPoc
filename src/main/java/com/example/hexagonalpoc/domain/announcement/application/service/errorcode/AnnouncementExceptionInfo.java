package com.example.hexagonalpoc.domain.announcement.application.service.errorcode;

import com.example.hexagonalpoc.common.exception.ExceptionInfo;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Getter
public enum AnnouncementExceptionInfo implements ExceptionInfo {

    // 공지사항 유무
    ALREADY_EXIST_ANNOUNCEMENT(BAD_REQUEST, "이미 작성된 공지사항입니다."),
    NOT_EXIST_ANNOUNCEMENT(BAD_REQUEST, "해당 공지사항을 찾을 수가 없습니다."),
    ANNOUNCEMENT_NONE(BAD_REQUEST, "작성된 공지사항이 없습니다."),

    // 날짜 관련
    NONE_INSERT_DATETIME(BAD_REQUEST, "원하는 날짜 VALUE가 들어오지 않았습니다."),

    NOT_NULL_ERROR(BAD_REQUEST, "원하는 값이 들어오지 않았습니다.");

    private final HttpStatus httpStatus;
    private final String message;

    AnnouncementExceptionInfo(HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }

    @Override
    public HttpStatus getHttpStatus() {
        return this.httpStatus;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
