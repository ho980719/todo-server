package com.ho.todoserver.todo.repository;

import com.ho.todoserver.todo.dto.TodoDto;
import com.ho.todoserver.todo.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

    List<Todo> findAllByMemberIdAndDate(Long memberId, String date);
}
