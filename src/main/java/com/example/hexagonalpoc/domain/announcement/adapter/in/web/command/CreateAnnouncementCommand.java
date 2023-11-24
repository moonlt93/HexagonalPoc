package com.example.hexagonalpoc.domain.announcement.adapter.in.web.command;


import io.micrometer.common.util.StringUtils;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.time.LocalDateTime;

public record CreateAnnouncementCommand(
        @NotEmpty(message = "writer Id는 null 일 수 없습니다.") String writer,
        @NotEmpty(message = "title은 null 일 수 없습니다.") String title,
        @NotEmpty(message = "content는 null 일 수 없습니다.") String content,
        @NotNull(message = "announcementStartDateTime은 null 일 수 없습니다.") LocalDateTime announcementStartDateTime,
        @NotNull(message = "announcementEndDateTime은 null 일 수 없습니다.") LocalDateTime announcementEndDateTime,
        String subTitle) {
    @Builder
    public CreateAnnouncementCommand(
            String writer,
            String title,
            String content,
            LocalDateTime announcementStartDateTime,
            LocalDateTime announcementEndDateTime,
            String subTitle
    ) {
        this.writer = writer;
        this.title = title;
        this.content = content;
        this.announcementStartDateTime = announcementStartDateTime;
        this.announcementEndDateTime = announcementEndDateTime;
        this.subTitle = subTitle;
    }

    private boolean hasInsertPassword(String password) {
        return StringUtils.isEmpty(password) ? true : false;
    }
}
