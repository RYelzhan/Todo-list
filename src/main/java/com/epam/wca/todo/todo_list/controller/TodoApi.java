package com.epam.wca.todo.todo_list.controller;

import com.epam.wca.todo.todo_list.dto.CreateTodoDTO;
import com.epam.wca.todo.todo_list.dto.TodoDTO;
import com.epam.wca.todo.todo_list.dto.UpdateTodoDTO;
import com.epam.wca.todo.todo_list.entity.Todo;
import com.epam.wca.todo.todo_list.entity.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Tag(name = "Todo Management System", description = "API for managing todos")
public interface TodoApi {

    @Operation(summary = "Add a new todo item", description = "Stores a new todo in the database",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Successfully created todo",
                            content = @Content(schema = @Schema(implementation = Todo.class)))
            })
    @PostMapping
    void createTodo(@AuthenticationPrincipal User authenticatedUser, @RequestBody CreateTodoDTO createTodoDTO);

    @Operation(summary = "Get user's todo items", description = "Retrieves all user's todos from the database",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Successfully retrieved list of todos",
                            content = @Content(schema = @Schema(implementation = Todo.class)))
            })
    @GetMapping
    List<TodoDTO> getUserTodos(@AuthenticationPrincipal User authenticatedUser);

    @Operation(summary = "Update a todo item", description = "Updates an existing todo in the database",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Successfully updated todo",
                            content = @Content(schema = @Schema(implementation = Todo.class)))
            })
    @PutMapping("/{id}")
    void updateTodo(@PathVariable("id") long id,
                    @RequestBody UpdateTodoDTO updateTodoDTO);

    @Operation(summary = "Delete a todo item", description = "Deletes a todo from the database",
            responses = {
                    @ApiResponse(responseCode = "204", description = "Successfully deleted todo")
            })
    @DeleteMapping("/{id}")
    void deleteTodo(@PathVariable("id") long id);
}
