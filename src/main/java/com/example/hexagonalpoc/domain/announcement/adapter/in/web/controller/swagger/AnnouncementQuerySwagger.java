package com.example.hexagonalpoc.domain.announcement.adapter.in.web.controller.swagger;


import com.example.hexagonalpoc.common.response.Response;
import com.example.hexagonalpoc.domain.announcement.adapter.in.web.request.SearchAnnouncementRequest;
import com.example.hexagonalpoc.domain.announcement.adapter.in.web.response.AnnouncementResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Tag(name = "공지사항 조회(Announcement)", description = "관리자 공지사항 조회 API")
public interface AnnouncementQuerySwagger {

    @Operation(summary = "공지사항 전체 조회")
    @ApiResponses({
        @ApiResponse(
                responseCode = "200",
                description = "공지사항 전체 조회",
                content =
                        @Content(
                                mediaType = "application/json",
                                array = @ArraySchema(schema = @Schema(implementation = List.class))))
    })
    @GetMapping
    Response<List<AnnouncementResponse>> getAllAnnouncement();

    @Operation(summary = "공지사항 상세 조회")
    @ApiResponses({
        @ApiResponse(
                responseCode = "200",
                description = "공지사항 상세 조회",
                content =
                        @Content(
                                mediaType = "application/json",
                                array = @ArraySchema(schema = @Schema(implementation = AnnouncementResponse.class))))
    })
    @GetMapping(value = "/detail")
    Response<AnnouncementResponse> getDetailAnnouncement(@RequestBody SearchAnnouncementRequest request);

    @Operation(summary = "공지사항 조건에 따른 filtering 조회")
    @ApiResponses({
        @ApiResponse(
                responseCode = "200",
                description = "공지사항 조건에 따른 filtering 조회",
                content =
                        @Content(
                                mediaType = "application/json",
                                array = @ArraySchema(schema = @Schema(implementation = List.class))))
    })
    @GetMapping("/search")
    Response<List<AnnouncementResponse>> getfilterAnnouncement(@RequestBody SearchAnnouncementRequest request);


}
