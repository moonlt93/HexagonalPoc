package com.example.hexagonalpoc.domain.announcement.adapter.in.web.mapper;




import com.example.hexagonalpoc.common.annotation.WebMapper;
import com.example.hexagonalpoc.domain.announcement.adapter.in.web.request.SearchAnnouncementRequest;
import com.example.hexagonalpoc.domain.announcement.adapter.in.web.response.AnnouncementResponse;
import com.example.hexagonalpoc.domain.announcement.application.domain.Announcement;

import java.util.List;

@WebMapper
public class AnnouncementWebMapper {

    public Announcement toRequestSearchDomain(SearchAnnouncementRequest request) {
        return Announcement.builder()
                .announcementId(request.getAnnouncementId())
                .title(request.getTitle())
                .announcementStartDateTime(request.getAnnouncementStartDateTime())
                .announcementEndDateTime(request.getAnnouncementEndDateTime())
                .build();
    }

    public AnnouncementResponse toResponse(Announcement announcement) {
        return AnnouncementResponse.builder()
                .announcementId(announcement.getAnnouncementId())
                .announcementTitle(announcement.getTitle())
                .writer(announcement.getWriter())
                .announcementContent(announcement.getContent())
                .announcementStartDateTime(announcement.getAnnouncementStartDateTime())
                .announcementEndDateTime(announcement.getAnnouncementEndDateTime())
                .build();
    }


    public List<AnnouncementResponse> toResponseList(List<Announcement> announcement) {
        return announcement.stream().map(this::toResponse).toList();
    }


}
