package com.example.hexagonalpoc.domain.announcement.adapter.in.web.response;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AnnouncementResponse {

    @Schema(
            requiredMode = Schema.RequiredMode.REQUIRED,
            nullable = false,
            description = "announcementId 해당 공지사항 Id",
            example = "1")
    private Long announcementId;

    @Schema(
            requiredMode = Schema.RequiredMode.REQUIRED,
            nullable = false,
            description = "해당 공지 title",
            example = "공지사항 title")
    private String announcementTitle;

    @Schema(
            requiredMode = Schema.RequiredMode.REQUIRED,
            nullable = false,
            description = "해당 공지 내용",
            example = "공지사항 내용")
    private String announcementContent;


    @Schema(requiredMode = Schema.RequiredMode.REQUIRED, nullable = false, description = "공지 작성자", example = "관리자")
    private String writer;

    @Schema(
            requiredMode = Schema.RequiredMode.REQUIRED,
            nullable = false,
            description = "공지 시작일자",
            example = "2023-11-10T11:22:33")
    private LocalDateTime announcementStartDateTime;

    @Schema(
            requiredMode = Schema.RequiredMode.REQUIRED,
            nullable = false,
            description = "공지 마감일자",
            example = "2023-11-10T11:22:33")
    private LocalDateTime announcementEndDateTime;

    @Builder
    public AnnouncementResponse(Long announcementId, String announcementTitle, String announcementContent, String writer, LocalDateTime announcementStartDateTime, LocalDateTime announcementEndDateTime) {
        this.announcementId = announcementId;
        this.announcementTitle = announcementTitle;
        this.announcementContent = announcementContent;
        this.writer = writer;
        this.announcementStartDateTime = announcementStartDateTime;
        this.announcementEndDateTime = announcementEndDateTime;
    }
}
