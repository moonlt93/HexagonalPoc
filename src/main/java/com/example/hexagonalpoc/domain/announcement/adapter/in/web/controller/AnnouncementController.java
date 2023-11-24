package com.example.hexagonalpoc.domain.announcement.adapter.in.web.controller;


import com.example.hexagonalpoc.common.response.ResponseBuilder;
import com.example.hexagonalpoc.domain.announcement.adapter.in.web.command.CreateAnnouncementCommand;
import com.example.hexagonalpoc.domain.announcement.adapter.in.web.command.DeleteAnnouncementCommand;
import com.example.hexagonalpoc.domain.announcement.adapter.in.web.command.ModifyAnnouncementCommand;
import com.example.hexagonalpoc.domain.announcement.adapter.in.web.controller.swagger.AnnouncementSwagger;
import com.example.hexagonalpoc.domain.announcement.adapter.in.web.mapper.CreateAnnouncementWebMapper;
import com.example.hexagonalpoc.domain.announcement.adapter.in.web.mapper.DeleteAnnouncementWebMapper;
import com.example.hexagonalpoc.domain.announcement.adapter.in.web.mapper.ModifyAnnouncementWebMapper;
import com.example.hexagonalpoc.domain.announcement.adapter.in.web.request.CreateAnnouncementRequest;
import com.example.hexagonalpoc.domain.announcement.adapter.in.web.request.DeleteAnnouncementRequest;
import com.example.hexagonalpoc.domain.announcement.adapter.in.web.request.ModifyAnnouncementRequest;
import com.example.hexagonalpoc.domain.announcement.application.domain.Announcement;
import com.example.hexagonalpoc.domain.announcement.application.port.in.CreateAnnouncementUseCase;
import com.example.hexagonalpoc.domain.announcement.application.port.in.DeleteAnnouncementUseCase;
import com.example.hexagonalpoc.domain.announcement.application.port.in.ModifyAnnouncementUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

import static org.springframework.http.HttpStatus.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/announcement")
@RequiredArgsConstructor
public class AnnouncementController implements AnnouncementSwagger {

    private final CreateAnnouncementUseCase createAnnouncementUseCase;
    private final ModifyAnnouncementUseCase modifyAnnouncementUseCase;
    private final DeleteAnnouncementUseCase deleteAnnouncementUseCase;
    private final CreateAnnouncementWebMapper createAnnouncementWebMapper;
    private final ModifyAnnouncementWebMapper modifyAnnouncementWebMapper;
    private final DeleteAnnouncementWebMapper deleteAnnouncementWebMapper;

    @PostMapping
    public ResponseEntity<Object> createAnnouncement(@RequestBody CreateAnnouncementRequest request)
            throws IOException {

        CreateAnnouncementCommand createAnnouncementCommand = createAnnouncementWebMapper.mapToCommand(request);
        Announcement announcement = createAnnouncementUseCase.createAnnouncement(createAnnouncementCommand);

        return ResponseBuilder.build(announcement, CREATED);
    }

    @PatchMapping("/modify")
    public ResponseEntity<Object> updateAnnouncement(@RequestBody ModifyAnnouncementRequest request) {

        ModifyAnnouncementCommand modifyAnnouncementCommand = modifyAnnouncementWebMapper.mapToCommand(request);
        Announcement modifyAnnouncement = modifyAnnouncementUseCase.modifyAnnouncement(modifyAnnouncementCommand);

        return ResponseBuilder.build(modifyAnnouncement, ACCEPTED);
    }

    @DeleteMapping
    public ResponseEntity<Object> deleteAnnouncement(@RequestBody DeleteAnnouncementRequest request) {

        DeleteAnnouncementCommand deleteAnnouncementCommand = deleteAnnouncementWebMapper.mapToCommand(request);
        boolean isOk = deleteAnnouncementUseCase.deleteAnnouncement(deleteAnnouncementCommand);

        return ResponseBuilder.build(isOk, OK);
    }



}
