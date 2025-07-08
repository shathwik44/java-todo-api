package com.shathwik.todo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shathwik.todo.model.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    List<Todo> findByCompletedFalse();
}
