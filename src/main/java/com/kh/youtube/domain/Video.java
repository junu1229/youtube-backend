package com.kh.youtube.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@DynamicInsert
@DynamicUpdate
public class Video {

    @Id
    @Column(name = "VIDEO_CODE")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "videoSequence")
    @SequenceGenerator(name = "videoSequence", sequenceName = "SEQ_VIDEO", allocationSize = 1)
    private int videoCode;

    @Column(name = "VIDEO_TITLE")
    private String videoTitle;

    @Column(name = "VIDEO_DESC")
    private String videoDesc;

    @Column(name = "VIDEO_DATE")
    private Date videoDate;

    @Column(name = "VIDEO_VIEWS")
    private int videoViews;

    @Column(name = "VIDEO_URL")
    private String videoUrl;

    @Column(name = "VIDEO_PHOTO")
    private String videoPhoto;

    @ManyToOne
    @JoinColumn(name = "category_code")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "CHANNEL_CODE")
    private Channel channel;

    @ManyToOne // Channel 엔티티와 Member 엔티티를 다대일 관계로 설정
    @JoinColumn(name = "id")
    private Member member;
}
