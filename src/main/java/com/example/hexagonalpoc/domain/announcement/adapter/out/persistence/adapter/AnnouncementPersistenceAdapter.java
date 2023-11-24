package com.example.hexagonalpoc.domain.announcement.adapter.out.persistence.adapter;


import com.example.hexagonalpoc.common.annotation.PersistenceAdapter;
import com.example.hexagonalpoc.domain.announcement.adapter.out.persistence.entity.AnnouncementJpaEntity;
import com.example.hexagonalpoc.domain.announcement.adapter.out.persistence.mapper.AnnouncementMapper;
import com.example.hexagonalpoc.domain.announcement.adapter.out.persistence.repository.AnnouncementJpaRepository;
import com.example.hexagonalpoc.domain.announcement.application.domain.Announcement;
import com.example.hexagonalpoc.domain.announcement.application.port.out.DeleteAnnouncementPort;
import com.example.hexagonalpoc.domain.announcement.application.port.out.LoadAnnouncementPort;
import com.example.hexagonalpoc.domain.announcement.application.port.out.ModifyAnnouncementPort;
import com.example.hexagonalpoc.domain.announcement.application.port.out.SaveAnnouncementPort;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@PersistenceAdapter
@RequiredArgsConstructor
public class AnnouncementPersistenceAdapter
        implements LoadAnnouncementPort, SaveAnnouncementPort, ModifyAnnouncementPort, DeleteAnnouncementPort {

    private final AnnouncementJpaRepository announcementJpaRepository;
    private final AnnouncementMapper announcementMapper;

    @Override
    public Announcement saveAnnouncement(Announcement announcement) {

        AnnouncementJpaEntity newNotice =
                announcementJpaRepository.save(announcementMapper.mapToJpaEntity(announcement));

        return announcementMapper.mapToDomain(newNotice);
    }

    @Override
    public Announcement updateAnnouncement(Announcement announcement) {

        AnnouncementJpaEntity announcementJpaEntity = announcementMapper.mapToJpaEntity(announcement);
        return announcementMapper.mapToDomain(announcementJpaRepository.save(announcementJpaEntity));
    }

    @Override
    public Boolean deleteAnnouncement(Long id) {

        announcementJpaRepository.findById(id).orElseThrow(EntityNotFoundException::new);

        announcementJpaRepository.deleteJpaNotice(id);
        return true;
    }

    @Override
    public Announcement loadAnnouncementWithId(Long id) {
        AnnouncementJpaEntity announcementJpaEntity =
                announcementJpaRepository.findById(id).orElseThrow(EntityNotFoundException::new);

        return announcementMapper.mapToDomain(announcementJpaEntity);
    }

    @Override
    public List<Announcement> loadAllAnnouncementIn(Announcement announcement) {

        return announcementJpaRepository.searchAnnouncement(announcement).stream()
                .map(announcementMapper::mapToDomain)
                .collect(Collectors.toList());
    }

    // query 모든 공지사항 조회
    @Override
    public List<Announcement> loadAllAnnouncement() {
        List<AnnouncementJpaEntity> jpaEntityList = announcementJpaRepository.findAll();

        return jpaEntityList.stream().map(announcementMapper::mapToDomain).toList();
    }
}
