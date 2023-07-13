package com.ho.todoserver.todo.entity;

import com.ho.todoserver.common.entity.BaseEntity;
import com.ho.todoserver.member.entity.Member;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Where;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Builder
@Entity
@Table(name = "todo")
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@DynamicUpdate
@Where(clause = "deleted = false")
public class Todo extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    private String title;
    private String date;

    @ColumnDefault("false")
    private Boolean completed;

    public Todo(Long id, Member member, String title, String date, Boolean completed) {
        this.id = id;
        this.member = member;
        this.title = title;
        this.date = date;
        this.completed = completed;
    }

    public void complete() {
        this.completed = !this.completed;
    }

    public void update(String title) {
        this.title = title;
    }
}
