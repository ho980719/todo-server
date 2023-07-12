package com.ho.todoserver.todo.service;

import com.ho.todoserver.common.exception.ApiException;
import com.ho.todoserver.common.status.ExceptionStatus;
import com.ho.todoserver.todo.dto.TodoDto;
import com.ho.todoserver.todo.entity.Todo;
import com.ho.todoserver.todo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class TodoService {
    private final TodoRepository todoRepository;

    public List<TodoDto> getTodos(Long memberId, String date) {
        return todoRepository.findAllByMemberIdAndDate(memberId, date)
                .stream()
                .map((t) -> new TodoDto(t))
                .collect(Collectors.toList());
    }

    public TodoDto complete(Long id) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new ApiException(ExceptionStatus.VALIDATION_FAIL));

        todo.complete();

        return new TodoDto(todo);
    }
}
