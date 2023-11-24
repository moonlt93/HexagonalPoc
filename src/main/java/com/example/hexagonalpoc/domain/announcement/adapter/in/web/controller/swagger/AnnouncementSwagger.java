package com.example.hexagonalpoc.domain.announcement.adapter.in.web.controller.swagger;



import com.example.hexagonalpoc.domain.announcement.adapter.in.web.request.CreateAnnouncementRequest;
import com.example.hexagonalpoc.domain.announcement.adapter.in.web.request.DeleteAnnouncementRequest;
import com.example.hexagonalpoc.domain.announcement.adapter.in.web.request.ModifyAnnouncementRequest;
import com.example.hexagonalpoc.domain.announcement.adapter.in.web.response.AnnouncementResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Tag(name = "공지사항(Announcement)", description = "관리자 공지사항 API")
public interface AnnouncementSwagger {

    @Operation(summary = "공지사항 생성")
    @ApiResponses({
        @ApiResponse(
                responseCode = "201",
                description = "공지사항 생성",
                content =
                        @Content(
                                mediaType = "application/json",
                                array = @ArraySchema(schema = @Schema(implementation = AnnouncementResponse.class))))
    })
    @PostMapping
    ResponseEntity<Object> createAnnouncement(@RequestBody CreateAnnouncementRequest request) throws IOException;

    @Operation(summary = "공지사항 수정")
    @ApiResponses({
        @ApiResponse(
                responseCode = "202",
                description = "공지사항 수정",
                content =
                        @Content(
                                mediaType = "application/json",
                                array =
                                        @ArraySchema(
                                                schema = @Schema(implementation = ModifyAnnouncementRequest.class))))
    })
    @PatchMapping("/modify")
    public ResponseEntity<Object> updateAnnouncement(@RequestBody ModifyAnnouncementRequest request);

    @Operation(summary = "공지사항 삭제")
    @DeleteMapping
    public ResponseEntity<Object> deleteAnnouncement(@RequestBody DeleteAnnouncementRequest request);


}
