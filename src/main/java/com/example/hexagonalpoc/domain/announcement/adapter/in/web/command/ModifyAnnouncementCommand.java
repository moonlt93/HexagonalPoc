package com.example.hexagonalpoc.domain.announcement.adapter.in.web.command;


import jakarta.validation.constraints.Positive;
import lombok.Builder;

public record ModifyAnnouncementCommand(
        @Positive(message = "announcementId는 0 보다커야합니다.") Long announcementId,
        String title,
        String content
) {
    @Builder
    public ModifyAnnouncementCommand(
            Long announcementId,
            String title,
            String content
    ) {
        this.announcementId = announcementId;
        this.title = title;
        this.content = content;
    }
}
