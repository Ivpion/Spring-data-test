package com.ivpion.model.entity.user;

import com.ivpion.model.entity.diary.CommentEntity;
import com.ivpion.model.entity.diary.LikeEntity;
import com.ivpion.model.entity.diary.PostEntity;
import com.ivpion.model.enums.SystemType;
import com.ivpion.model.enums.UserStatus;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "users")
public class UserEntry implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "terminal_user_uuid", nullable = false, unique = true, insertable = false, updatable = false)
    private String terminalUserUuid;

    @Column(name = "login", nullable = false)
    private String login;

    @Column(name = "password", nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private UserStatus status;

    @Column(name = "add_timestamp", nullable = false)
    private int addTimestamp;

    @Column(name = "personal_referral", nullable = false)
    private String personalReferral;

    @Column(name = "terminal_user_uuid")
    private String inviteReferralCode;

    @Enumerated(EnumType.STRING)
    @Column(name = "registration_type", nullable = false)
    private SystemType registrationType;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
    private UserProfileEntity userProfile;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PostEntity> posts;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CommentEntity> comments;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LikeEntity> likes;


    public UserEntry() {
    }

    public UserEntry(String terminalUserUuid, String login, String password, UserStatus status, int addTimestamp, String personalReferral, String inviteReferralCode, SystemType registrationType, UserProfileEntity userProfile) {
        this.terminalUserUuid = terminalUserUuid;
        this.login = login;
        this.password = password;
        this.status = status;
        this.addTimestamp = addTimestamp;
        this.personalReferral = personalReferral;
        this.inviteReferralCode = inviteReferralCode;
        this.registrationType = registrationType;
        this.userProfile = userProfile;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTerminalUserUuid() {
        return terminalUserUuid;
    }

    public void setTerminalUserUuid(String terminalUserUuid) {
        this.terminalUserUuid = terminalUserUuid;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }

    public int getAddTimestamp() {
        return addTimestamp;
    }

    public void setAddTimestamp(int addTimestamp) {
        this.addTimestamp = addTimestamp;
    }

    public String getPersonalReferral() {
        return personalReferral;
    }

    public void setPersonalReferral(String personalReferral) {
        this.personalReferral = personalReferral;
    }

    public String getInviteReferralCode() {
        return inviteReferralCode;
    }

    public void setInviteReferralCode(String inviteReferralCode) {
        this.inviteReferralCode = inviteReferralCode;
    }

    public SystemType getRegistrationType() {
        return registrationType;
    }

    public void setRegistrationType(SystemType registrationType) {
        this.registrationType = registrationType;
    }

    @Override
    public String toString() {
        return "UserEntry{" +
                "id=" + id +
                ", terminalUserUuid='" + terminalUserUuid + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", status=" + status +
                ", addTimestamp=" + addTimestamp +
                ", personalReferral='" + personalReferral + '\'' +
                ", inviteReferralCode='" + inviteReferralCode + '\'' +
                ", registrationType=" + registrationType +
                ", userProfile=" + userProfile +
                '}';
    }
}
