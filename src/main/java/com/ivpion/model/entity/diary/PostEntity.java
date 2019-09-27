package com.ivpion.model.entity.diary;

import com.ivpion.model.entity.user.UserEntry;
import com.ivpion.model.enums.Access;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString

@Entity
@Table(name = "posts")
public class PostEntity extends Auditable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntry user;
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "text")
    private String text;
    @Column(name = "publish_timestamp")
    private Date publishTimestamp;
    @Column(name = "is_moderated")
    private boolean isModerate;
    @Enumerated(EnumType.STRING)
    @Column(name = "access")
    private Access access;
    @Column(name = "forbid_comments", columnDefinition = "boolean default false")
    private boolean forbidComments;
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<CommentEntity> comments;
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<LikeEntity> likes;


}
