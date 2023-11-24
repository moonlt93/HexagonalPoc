package com.example.hexagonalpoc.domain.announcement.application.port.in;


import com.example.hexagonalpoc.domain.announcement.adapter.in.web.command.DeleteAnnouncementCommand;
import jakarta.validation.Valid;

public interface DeleteAnnouncementUseCase {

    Boolean deleteAnnouncement(@Valid DeleteAnnouncementCommand deleteAnnouncementCommand);

}
