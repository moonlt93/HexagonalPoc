package com.example.hexagonalpoc.domain.announcement.application.port.out;


import com.example.hexagonalpoc.domain.announcement.application.domain.Announcement;

import java.util.List;

public interface LoadAnnouncementPort {

    List<Announcement> loadAllAnnouncement();

    Announcement loadAnnouncementWithId(Long id);

    List<Announcement> loadAllAnnouncementIn(Announcement announcement);


}
