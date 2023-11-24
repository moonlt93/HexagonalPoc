package com.example.hexagonalpoc.domain.announcement.application.domain;


import com.amazonaws.util.StringUtils;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Announcement {

    private Long announcementId;
    private String writer;
    private String title;
    private String content;

    private LocalDateTime announcementStartDateTime;
    private LocalDateTime announcementEndDateTime;


    @Builder
    public Announcement(Long announcementId, String writer, String title, String content, LocalDateTime announcementStartDateTime, LocalDateTime announcementEndDateTime) {
        this.announcementId = announcementId;
        this.writer = writer;
        this.title = title;
        this.content = content;
        this.announcementStartDateTime = announcementStartDateTime;
        this.announcementEndDateTime = announcementEndDateTime;
    }

    public void updateContent(String content) {

        if (!StringUtils.isNullOrEmpty(content)) {
            this.content = content;
        }
    }

    public void updateTitle(String title) {

        if (!StringUtils.isNullOrEmpty(title)) {
            this.title = title;
        }
    }


}
