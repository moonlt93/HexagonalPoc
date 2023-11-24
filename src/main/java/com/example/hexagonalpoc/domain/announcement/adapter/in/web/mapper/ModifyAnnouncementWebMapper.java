package com.example.hexagonalpoc.domain.announcement.adapter.in.web.mapper;


import com.example.hexagonalpoc.common.annotation.WebMapper;
import com.example.hexagonalpoc.domain.announcement.adapter.in.web.command.ModifyAnnouncementCommand;
import com.example.hexagonalpoc.domain.announcement.adapter.in.web.request.ModifyAnnouncementRequest;

@WebMapper
public class ModifyAnnouncementWebMapper {
    public ModifyAnnouncementCommand mapToCommand(ModifyAnnouncementRequest request) {
        return new ModifyAnnouncementCommand(
                request.getAnnouncementId(),
                request.getTitle(),
                request.getContent()
        );

    }
}
