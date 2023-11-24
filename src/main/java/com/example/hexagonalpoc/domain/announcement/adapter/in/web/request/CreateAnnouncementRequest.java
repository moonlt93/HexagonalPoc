package com.example.hexagonalpoc.domain.announcement.adapter.in.web.request;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
public class CreateAnnouncementRequest {


    @Schema(requiredMode = Schema.RequiredMode.REQUIRED, nullable = false, description = "작성자 Id", example = "1")
    private String writer;

    @Schema(requiredMode = Schema.RequiredMode.REQUIRED, nullable = false, description = "공지사항 제목", example = "제목")
    private String title;

    @Schema(requiredMode = Schema.RequiredMode.NOT_REQUIRED, nullable = true, description = "공지사항 부제목", example = "부제목")
    private String subTitle;

    @Schema(
            requiredMode = Schema.RequiredMode.REQUIRED,
            nullable = false,
            description = "공지사항 컨텐츠내용",
            example = "컨텐츠내용")
    private String content;




    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, style = "yyyy-MM-ddTHH:mm:ss")
    private LocalDateTime announcementStartDateTime;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, style = "yyyy-MM-ddTHH:mm:ss")
    private LocalDateTime announcementEndDateTime;

    @Builder
    public CreateAnnouncementRequest(
            String title,
            String subTitle,
            String content,
            String writer,
            LocalDateTime announcementStartDateTime,
            LocalDateTime announcementEndDateTime
           ) {
        this.title = title;
        this.subTitle = subTitle;
        this.content = content;
        this.writer = writer;
        this.announcementStartDateTime = announcementStartDateTime;
        this.announcementEndDateTime = announcementEndDateTime;
    }
}
