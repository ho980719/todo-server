package com.ho.todoserver.todo.service;

import com.ho.todoserver.todo.dto.TodoDto;
import com.ho.todoserver.todo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TodoService {
    private final TodoRepository todoRepository;

    public Optional<TodoDto> getTodos(Long memberId, String date) {

        return todoRepository.findAllByMemberIdAndDate(memberId, date);
    }
}
