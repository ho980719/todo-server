package com.ho.todoserver.todo.dto;

import com.ho.todoserver.todo.entity.Todo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TodoDto {
    private Long id;
    private Long memberId;
    private String title;
    private String date;
    private Boolean completed;
    private Boolean deleted;

    public TodoDto (Todo todo) {
        this.id = todo.getId();
        this.memberId = todo.getMember().getId();
        this.title = todo.getTitle();
        this.date = todo.getDate();
        this.completed = todo.getCompleted();
        this.deleted = todo.getDeleted();
    }
}
