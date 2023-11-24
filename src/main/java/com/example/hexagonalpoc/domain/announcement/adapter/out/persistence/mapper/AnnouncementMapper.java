package com.example.hexagonalpoc.domain.announcement.adapter.out.persistence.mapper;



import com.example.hexagonalpoc.common.annotation.PersistenceMapper;
import com.example.hexagonalpoc.domain.announcement.adapter.out.persistence.entity.AnnouncementJpaEntity;
import com.example.hexagonalpoc.domain.announcement.application.domain.Announcement;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@PersistenceMapper
public class AnnouncementMapper {

    public AnnouncementJpaEntity mapToJpaEntity(Announcement announcement) {

        return AnnouncementJpaEntity.builder()
                .announcementId(announcement.getAnnouncementId())
                .title(announcement.getTitle())
                .writer(announcement.getWriter())
                .announcementStartDateTime(announcement.getAnnouncementStartDateTime())
                .announcementEndDateTime(announcement.getAnnouncementEndDateTime())
                .content(announcement.getContent())
                .build();
    }

    public Announcement mapToDomain(AnnouncementJpaEntity announcementJpaEntity) {
        return Announcement.builder()
                .announcementId(announcementJpaEntity.getAnnouncementId())
                .title(announcementJpaEntity.getTitle())
                .content(announcementJpaEntity.getContent())
                .writer(announcementJpaEntity.getWriter())
                .announcementStartDateTime(announcementJpaEntity.getAnnouncementStartDateTime())
                .announcementEndDateTime(announcementJpaEntity.getAnnouncementEndDateTime())
                .build();
    }

}
