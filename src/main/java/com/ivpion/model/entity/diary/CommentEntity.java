package com.ivpion.model.entity.diary;

import com.ivpion.model.entity.user.UserEntry;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
@Getter
@Setter
@NoArgsConstructor
@ToString

@Entity
@Table(name = "comments")
public class CommentEntity extends Auditable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntry user;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private PostEntity post;
    @Column(name = "text")
    private String text;
    @Column(name = "is_moderated", columnDefinition = "boolean default false")
    private boolean isModerate;

}
