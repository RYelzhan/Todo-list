package com.epam.wca.todo.todo_list.dto;

import jakarta.validation.constraints.Size;

public record UpdateTodoDTO(
        @Size(max = 100, message = "Title cannot be longer than 100 characters")
        String title,

        @Size(max = 500, message = "Description cannot be longer than 500 characters")
        String description
) {}
