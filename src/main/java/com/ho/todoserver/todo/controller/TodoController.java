package com.ho.todoserver.todo.controller;

import com.ho.todoserver.common.entity.ApiResponseEntity;
import com.ho.todoserver.todo.dto.TodoDto;
import com.ho.todoserver.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/todos")
public class TodoController {
    private final TodoService todoService;

    @GetMapping("/{memberId}/{date}")
    public ApiResponseEntity todos(@PathVariable Long memberId, @PathVariable String date) {
        return ApiResponseEntity.onSuccess(todoService.getTodos(memberId, date));
    }

    @PutMapping("/complete/{id}")
    public ApiResponseEntity complete(@PathVariable Long id) {
        return ApiResponseEntity.onSuccess(todoService.complete(id));
    }

    @PutMapping("/delete/{id}")
    public ApiResponseEntity delete(@PathVariable Long id) {
        return ApiResponseEntity.onSuccess(todoService.delete(id));
    }

    @ResponseBody
    @PatchMapping("/update")
    public ApiResponseEntity update(@RequestBody TodoDto todoDto) {
        return ApiResponseEntity.onSuccess(todoService.update(todoDto));
    }

}
