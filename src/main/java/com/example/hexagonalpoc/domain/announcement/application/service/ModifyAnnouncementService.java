package com.example.hexagonalpoc.domain.announcement.application.service;


import com.example.hexagonalpoc.domain.announcement.adapter.in.web.command.ModifyAnnouncementCommand;
import com.example.hexagonalpoc.domain.announcement.application.domain.Announcement;
import com.example.hexagonalpoc.domain.announcement.application.port.in.ModifyAnnouncementUseCase;
import com.example.hexagonalpoc.domain.announcement.application.port.out.LoadAnnouncementPort;
import com.example.hexagonalpoc.domain.announcement.application.port.out.ModifyAnnouncementPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

@Slf4j
@Service
@Validated
@RequiredArgsConstructor
public class ModifyAnnouncementService implements ModifyAnnouncementUseCase {

    private final ModifyAnnouncementPort modifyAnnouncementPort;
    private final LoadAnnouncementPort loadAnnouncementPort;

    @Override
    @Transactional
    public Announcement modifyAnnouncement(ModifyAnnouncementCommand modifyAnnouncementCommand) {

        Announcement announcement =
                loadAnnouncementPort.loadAnnouncementWithId(modifyAnnouncementCommand.announcementId());

        announcement.updateContent(modifyAnnouncementCommand.content());
        announcement.updateTitle(modifyAnnouncementCommand.title());

        return modifyAnnouncementPort.updateAnnouncement(announcement);
    }
}
