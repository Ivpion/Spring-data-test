package com.ivpion.model.entity.diary;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.util.Date;


@Getter(AccessLevel.PROTECTED)
@Setter(AccessLevel.PROTECTED)
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Auditable {
    @CreatedDate
    @Column(name = "create_timestamp")
    private Date createTimestamp;
}
