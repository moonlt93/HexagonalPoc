package com.example.hexagonalpoc.domain.announcement.adapter.in.web.request;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
public class ModifyAnnouncementRequest {

    @Schema(requiredMode = Schema.RequiredMode.REQUIRED, nullable = false, description = "수정할 공지사항 id", example = "1L")
    private Long announcementId;

    @Schema(requiredMode = Schema.RequiredMode.REQUIRED, nullable = true, description = "수정할 공지사항 제목", example = "1")
    private String title;

    @Schema(
            requiredMode = Schema.RequiredMode.REQUIRED,
            nullable = true,
            description = "수정할 공지사항 내용",
            example = "content")
    private String content;

    @Builder
    public ModifyAnnouncementRequest(
            Long announcementId,
            String title,
            String content) {

        this.announcementId = announcementId;
        this.title = title;
        this.content = content;

    }
}
