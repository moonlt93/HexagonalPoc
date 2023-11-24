package com.example.hexagonalpoc.domain.announcement.application.port.in;

import com.example.hexagonalpoc.domain.announcement.adapter.in.web.command.ModifyAnnouncementCommand;
import com.example.hexagonalpoc.domain.announcement.application.domain.Announcement;
import jakarta.validation.Valid;

public interface ModifyAnnouncementUseCase {

    Announcement modifyAnnouncement(@Valid ModifyAnnouncementCommand modifyAnnouncementCommand);
}
