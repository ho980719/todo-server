package com.ho.todoserver.todo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class TodoDto {
    private Long id;
    private String memberId;
    private String title;
    private String date;
    private Boolean completed;
    private Boolean deleted;
}
