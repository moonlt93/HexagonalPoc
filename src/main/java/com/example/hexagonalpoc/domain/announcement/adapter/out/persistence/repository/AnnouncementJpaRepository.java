package com.example.hexagonalpoc.domain.announcement.adapter.out.persistence.repository;



import com.example.hexagonalpoc.domain.announcement.adapter.out.persistence.entity.AnnouncementJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AnnouncementJpaRepository
        extends JpaRepository<AnnouncementJpaEntity, Long>, AnnouncementDslRepository {

    @Modifying
    @Query("delete from AnnouncementJpaEntity n where n.announcementId = :id")
    void deleteJpaNotice(@Param("id") Long announcementId);
}
