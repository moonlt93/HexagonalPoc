package com.example.hexagonalpoc.domain.announcement.adapter.in.web.request;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SearchAnnouncementRequest {

    @Schema(
            requiredMode = Schema.RequiredMode.REQUIRED,
            nullable = false,
            description = "announcementId 해당 공지사항 Id",
            example = "1")
    private Long announcementId;

    @NotNull
    @Schema(
            requiredMode = Schema.RequiredMode.REQUIRED,
            nullable = false,
            description = "공지적용 시작 일자",
            example = "yyyy-MM-ddTHH:mm:ss")
    private LocalDateTime announcementStartDateTime;

    @NotNull
    @Schema(
            requiredMode = Schema.RequiredMode.REQUIRED,
            nullable = false,
            description = "공지적용 마감 일자",
            example = "yyyy-MM-ddTHH:mm:ss")
    private LocalDateTime announcementEndDateTime;

    @Schema(requiredMode = Schema.RequiredMode.REQUIRED, nullable = true, description = "publisherId", example = "1")
    private String title;

    @Builder
    public SearchAnnouncementRequest(
            Long announcementId,
            LocalDateTime announcementStartDateTime,
            LocalDateTime announcementEndDateTime,
            String title) {
        this.announcementId = announcementId;
        this.announcementStartDateTime = announcementStartDateTime;
        this.announcementEndDateTime = announcementEndDateTime;
        this.title = title;
    }
}
