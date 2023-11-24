package com.example.hexagonalpoc.domain.announcement.application.service;


import com.example.hexagonalpoc.domain.announcement.adapter.in.web.command.DeleteAnnouncementCommand;
import com.example.hexagonalpoc.domain.announcement.application.port.in.DeleteAnnouncementUseCase;
import com.example.hexagonalpoc.domain.announcement.application.port.out.DeleteAnnouncementPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

@Slf4j
@Service
@Validated
@RequiredArgsConstructor
public class DeleteAnnouncementService implements DeleteAnnouncementUseCase {

    private final DeleteAnnouncementPort deleteAnnouncementPort;

    @Transactional
    @Override
    public Boolean deleteAnnouncement(DeleteAnnouncementCommand deleteAnnouncementCommand) {

        return deleteAnnouncementPort.deleteAnnouncement(deleteAnnouncementCommand.announcementId());
    }


}
