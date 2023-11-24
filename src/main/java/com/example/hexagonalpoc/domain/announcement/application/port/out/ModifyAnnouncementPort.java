package com.example.hexagonalpoc.domain.announcement.application.port.out;


import com.example.hexagonalpoc.domain.announcement.application.domain.Announcement;

public interface ModifyAnnouncementPort {

    Announcement updateAnnouncement(Announcement announcement);
}
