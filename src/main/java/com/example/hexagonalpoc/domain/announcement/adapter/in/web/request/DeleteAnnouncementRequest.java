package com.example.hexagonalpoc.domain.announcement.adapter.in.web.request;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Schema(description = "공지사항 수정 요청 DTO")
public class DeleteAnnouncementRequest {

    @Schema(requiredMode = Schema.RequiredMode.REQUIRED, nullable = false, description = "공지사항 ID", example = "1")
    private Long announcementId;

    @Builder
    public DeleteAnnouncementRequest(Long announcementId, Long fileId, String idList) {
        this.announcementId = announcementId;
    }
}
