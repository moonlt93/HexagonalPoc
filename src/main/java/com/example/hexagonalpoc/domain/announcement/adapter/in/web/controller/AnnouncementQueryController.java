package com.example.hexagonalpoc.domain.announcement.adapter.in.web.controller;


import com.example.hexagonalpoc.common.response.Response;
import com.example.hexagonalpoc.common.response.ResponseBuilder;
import com.example.hexagonalpoc.domain.announcement.adapter.in.web.controller.swagger.AnnouncementQuerySwagger;
import com.example.hexagonalpoc.domain.announcement.adapter.in.web.mapper.AnnouncementWebMapper;
import com.example.hexagonalpoc.domain.announcement.adapter.in.web.request.SearchAnnouncementRequest;
import com.example.hexagonalpoc.domain.announcement.adapter.in.web.response.AnnouncementResponse;
import com.example.hexagonalpoc.domain.announcement.application.domain.Announcement;
import com.example.hexagonalpoc.domain.announcement.application.port.out.LoadAnnouncementPort;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/api/v1/announcement")
@RequiredArgsConstructor
public class AnnouncementQueryController implements AnnouncementQuerySwagger {

    private final LoadAnnouncementPort loadAnnouncementPort;
    private final AnnouncementWebMapper announcementWebMapper;

    @GetMapping
    public Response<List<AnnouncementResponse>> getAllAnnouncement() {

        List<Announcement> announcementList = loadAnnouncementPort.loadAllAnnouncement();
        List<AnnouncementResponse> announcementResponseList = announcementWebMapper.toResponseList(announcementList);

        return ResponseBuilder.build(announcementResponseList);
    }

    @GetMapping(value = "/detail")
    public Response<AnnouncementResponse> getDetailAnnouncement(@RequestBody SearchAnnouncementRequest request) {

        Announcement announcement = loadAnnouncementPort.loadAnnouncementWithId(request.getAnnouncementId());
        AnnouncementResponse responseNotice = announcementWebMapper.toResponse(announcement);

        return ResponseBuilder.build(responseNotice);
    }

    @GetMapping("/search")
    public Response<List<AnnouncementResponse>> getfilterAnnouncement(
            @Valid @RequestBody SearchAnnouncementRequest request) {

        List<Announcement> announcements =
                loadAnnouncementPort.loadAllAnnouncementIn(announcementWebMapper.toRequestSearchDomain(request));
        List<AnnouncementResponse> responseList = announcementWebMapper.toResponseList(announcements);

        return ResponseBuilder.build(responseList);
    }

}
