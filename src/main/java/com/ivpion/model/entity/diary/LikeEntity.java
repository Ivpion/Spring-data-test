package com.ivpion.model.entity.diary;

import com.ivpion.model.entity.user.UserEntry;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@ToString

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "likes")
public class LikeEntity extends Auditable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntry user;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private PostEntity post;
    @CreatedDate
    @Column(name = "create_timestamp")
    private Date createTimestamp;
}
