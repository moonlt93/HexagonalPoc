package com.example.hexagonalpoc.domain.announcement.application.port.in;


import com.example.hexagonalpoc.domain.announcement.adapter.in.web.command.CreateAnnouncementCommand;
import com.example.hexagonalpoc.domain.announcement.application.domain.Announcement;
import jakarta.validation.Valid;

import java.io.IOException;

public interface CreateAnnouncementUseCase {

    Announcement createAnnouncement(@Valid CreateAnnouncementCommand createAnnouncementCommand) throws IOException;

}
