package com.epam.wca.todo.todo_list.controller;

import com.epam.wca.todo.todo_list.dto.CreateTodoDTO;
import com.epam.wca.todo.todo_list.dto.TodoDTO;
import com.epam.wca.todo.todo_list.dto.UpdateTodoDTO;
import com.epam.wca.todo.todo_list.entity.User;
import com.epam.wca.todo.todo_list.service.TodoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
@RequiredArgsConstructor
public class TodoController implements TodoApi {

    private final TodoService todoService;

    @Override
    @ResponseStatus(HttpStatus.CREATED)
    public void createTodo(
            @AuthenticationPrincipal User authenticatedUser,
            @Valid @RequestBody CreateTodoDTO createTodoDTO
    ) {
        todoService.createTodo(authenticatedUser, createTodoDTO);
    }

    @Override
    @ResponseStatus(HttpStatus.OK)
    public List<TodoDTO> getUserTodos(
            @AuthenticationPrincipal User authenticatedUser
    ) {
        return todoService.getUserTodos(authenticatedUser);
    }

    @Override
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateTodo(
            @PathVariable("id") long id,
            @Valid @RequestBody UpdateTodoDTO updateTodoDTO
    ) {
        todoService.updateTodo(id, updateTodoDTO);
    }

    @Override
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTodo(
            @PathVariable("id") long id
    ) {
        todoService.deleteTodo(id);
    }
}