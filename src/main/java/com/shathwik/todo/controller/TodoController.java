package com.shathwik.todo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shathwik.todo.model.Todo;
import com.shathwik.todo.repository.TodoRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/todos")
public class TodoController {
    private final TodoRepository repo;

    public TodoController(TodoRepository repo) {
        this.repo = repo;
    }

    @PostMapping
    public Todo create(@RequestBody Todo todo) {
        return repo.save(todo);
    }

    @GetMapping
    public List<Todo> getAll() {
        return repo.findAll();
    }

    @GetMapping("/incomplete")
    public List<Todo> getIncomplete() {
        return repo.findByCompletedFalse();
    }

    @PutMapping("/{id}")
    public Todo update(@PathVariable Long id, @RequestBody Todo updated) {
        return repo.findById(id).map(todo -> {
            todo.title = updated.title;
            todo.completed = updated.completed;
            return repo.save(todo);
        }).orElseThrow(() -> new RuntimeException("Todo Not Found"));
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return "Deleted Todo";
        }
        return "Todo does not exists";
    }

}
