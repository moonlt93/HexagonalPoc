package com.example.hexagonalpoc.domain.announcement.adapter.in.web.mapper;


import com.example.hexagonalpoc.common.annotation.WebMapper;
import com.example.hexagonalpoc.domain.announcement.adapter.in.web.command.CreateAnnouncementCommand;
import com.example.hexagonalpoc.domain.announcement.adapter.in.web.request.CreateAnnouncementRequest;

@WebMapper
public class CreateAnnouncementWebMapper {

    public CreateAnnouncementCommand mapToCommand(CreateAnnouncementRequest request) {
        return CreateAnnouncementCommand.builder()
                .writer(request.getWriter())
                .title(request.getTitle())
                .content(request.getContent())
                .announcementStartDateTime(request.getAnnouncementStartDateTime())
                .announcementEndDateTime(request.getAnnouncementEndDateTime())
                .subTitle(request.getSubTitle())
                .build();
    }
}
