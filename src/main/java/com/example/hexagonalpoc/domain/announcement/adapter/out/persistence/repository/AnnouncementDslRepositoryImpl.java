package com.example.hexagonalpoc.domain.announcement.adapter.out.persistence.repository;


import com.example.hexagonalpoc.domain.announcement.adapter.out.persistence.entity.AnnouncementJpaEntity;
import com.example.hexagonalpoc.domain.announcement.application.domain.Announcement;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import io.micrometer.common.util.StringUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import static com.example.hexagonalpoc.domain.announcement.adapter.out.persistence.entity.QAnnouncementJpaEntity.announcementJpaEntity;


@RequiredArgsConstructor
@Slf4j
public class AnnouncementDslRepositoryImpl implements AnnouncementDslRepository {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<AnnouncementJpaEntity> searchAnnouncement(Announcement announcement) {

        return queryFactory
                .selectFrom(announcementJpaEntity)
                .where(
                        eqTitle(announcement.getTitle()),
                        announcementDateTimeBetween(
                                announcement.getAnnouncementStartDateTime(), announcement.getAnnouncementEndDateTime()))
                .fetch();
    }

    // 조회한 기간에 해당하는 공지사항만 조회
    private BooleanExpression announcementDateTimeBetween(
            LocalDateTime announcementStartDateTime, LocalDateTime announcementEndDateTime) {

        LocalDate startDate = announcementStartDateTime.toLocalDate();
        LocalDate endDate = announcementEndDateTime.toLocalDate();

        BooleanExpression isGoeStartDate =
                announcementJpaEntity.announcementStartDateTime.goe(LocalDateTime.of(startDate, LocalTime.MIN));
        BooleanExpression isLoeEndDate =
                announcementJpaEntity.announcementEndDateTime.loe(LocalDateTime.of(endDate, LocalTime.MAX));

        return Expressions.allOf(isGoeStartDate, isLoeEndDate);
    }

    private BooleanExpression eqTitle(String title) {
        if (StringUtils.isEmpty(title)) {
            return null;
        }
        return announcementJpaEntity.title.eq(title);
    }
}
