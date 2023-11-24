package com.example.hexagonalpoc.domain.announcement.application.port.out;

import com.example.hexagonalpoc.domain.announcement.application.domain.Announcement;

public interface SaveAnnouncementPort {

    Announcement saveAnnouncement(Announcement announcement);

}
