package com.example.hexagonalpoc.domain.announcement.adapter.in.web.command;


import jakarta.validation.constraints.Positive;
import lombok.Builder;

public record DeleteAnnouncementCommand(

        @Positive(message = "announcementId는 0 보다커야합니다.") Long announcementId
) {

    @Builder
    public DeleteAnnouncementCommand(Long announcementId) {
        this.announcementId = announcementId;
    }
}
