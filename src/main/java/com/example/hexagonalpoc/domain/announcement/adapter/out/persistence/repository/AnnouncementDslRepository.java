package com.example.hexagonalpoc.domain.announcement.adapter.out.persistence.repository;


import com.example.hexagonalpoc.domain.announcement.adapter.out.persistence.entity.AnnouncementJpaEntity;
import com.example.hexagonalpoc.domain.announcement.application.domain.Announcement;

import java.util.List;

public interface AnnouncementDslRepository {

    List<AnnouncementJpaEntity> searchAnnouncement(Announcement announcement);
}
