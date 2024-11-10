package com.epam.wca.todo.todo_list.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
public class ErrorDetails {
    private HttpStatus status;
    private String message;
    private String details;
}
