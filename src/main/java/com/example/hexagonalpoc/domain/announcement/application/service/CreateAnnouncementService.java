package com.example.hexagonalpoc.domain.announcement.application.service;


import com.example.hexagonalpoc.domain.announcement.adapter.in.web.command.CreateAnnouncementCommand;
import com.example.hexagonalpoc.domain.announcement.application.domain.Announcement;
import com.example.hexagonalpoc.domain.announcement.application.port.in.CreateAnnouncementUseCase;
import com.example.hexagonalpoc.domain.announcement.application.port.out.SaveAnnouncementPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

@Slf4j
@Service
@Validated
@RequiredArgsConstructor
public class CreateAnnouncementService implements CreateAnnouncementUseCase {

    private final SaveAnnouncementPort saveAnnouncementPort;

    @Override
    public Announcement createAnnouncement(CreateAnnouncementCommand createAnnouncementCommand) throws IOException {

        Announcement announcement = Announcement.builder()
                .title(createAnnouncementCommand.title())
                .content(createAnnouncementCommand.content())
                .writer(createAnnouncementCommand.writer())
                .announcementStartDateTime(createAnnouncementCommand.announcementStartDateTime())
                .announcementEndDateTime(createAnnouncementCommand.announcementEndDateTime())
                .build();

        return saveAnnouncementPort.saveAnnouncement(announcement);
    }


}
