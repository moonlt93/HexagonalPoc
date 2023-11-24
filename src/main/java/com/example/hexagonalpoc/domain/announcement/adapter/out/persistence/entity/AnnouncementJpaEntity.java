package com.example.hexagonalpoc.domain.announcement.adapter.out.persistence.entity;


import com.example.hexagonalpoc.common.valuetype.GroupCodeBaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Comment;

import java.time.LocalDateTime;


@Entity
@Getter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "NTCE_MAST")
public class AnnouncementJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BORD_IDCD")
    private Long announcementId;

    @Comment("작성자")
    private String writer;

    @Comment("제목")
    private String title;

    @Comment("서브제목")
    private String subTitle;

    @Comment("내용")
    private String content;

    @Comment("공지사항 게시일자")
    private LocalDateTime announcementStartDateTime;

    @Comment("공지사항 마감일자")
    private LocalDateTime announcementEndDateTime;

}
