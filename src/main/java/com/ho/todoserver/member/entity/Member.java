package com.ho.todoserver.member.entity;

import com.ho.todoserver.common.entity.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Builder
@Entity
@Table(name = "member")
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@DynamicUpdate
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    @NotEmpty(message = "로그인 아이디는 필수 값입니다.")
    private String loginId;

    @Column(length = 100, nullable = false)
    @NotEmpty(message = "이름은 필수 값입니다.")
    private String name;

    @Column(length = 100, nullable = false)
    @NotEmpty(message = "비밀번호는 필수 값입니다.")
    private String password;

    public Member(Long id, String loginId, String name, String password) {
        this.id = id;
        this.loginId = loginId;
        this.name = name;
        this.password = password;
    }
    public Member(String loginId, String name, String password) {
        this.loginId = loginId;
        this.name = name;
        this.password = password;
    }
}
