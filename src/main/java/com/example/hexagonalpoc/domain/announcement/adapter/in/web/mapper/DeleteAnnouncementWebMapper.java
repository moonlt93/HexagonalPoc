package com.example.hexagonalpoc.domain.announcement.adapter.in.web.mapper;


import com.example.hexagonalpoc.common.annotation.WebMapper;
import com.example.hexagonalpoc.domain.announcement.adapter.in.web.command.DeleteAnnouncementCommand;
import com.example.hexagonalpoc.domain.announcement.adapter.in.web.request.DeleteAnnouncementRequest;

@WebMapper
public class DeleteAnnouncementWebMapper {
    public DeleteAnnouncementCommand mapToCommand(DeleteAnnouncementRequest request) {
        return new DeleteAnnouncementCommand(request.getAnnouncementId());
    }
}
