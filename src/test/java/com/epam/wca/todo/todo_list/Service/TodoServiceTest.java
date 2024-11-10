package com.epam.wca.todo.todo_list.Service;

import com.epam.wca.todo.todo_list.dto.CreateTodoDTO;
import com.epam.wca.todo.todo_list.dto.TodoDTO;
import com.epam.wca.todo.todo_list.dto.UpdateTodoDTO;
import com.epam.wca.todo.todo_list.entity.Todo;
import com.epam.wca.todo.todo_list.entity.User;
import com.epam.wca.todo.todo_list.repository.TodoRepository;
import com.epam.wca.todo.todo_list.repository.UserRepository;
import com.epam.wca.todo.todo_list.service.TodoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TodoServiceTest {

    @Mock
    private TodoRepository todoRepository;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private TodoService todoService;

    @Test
    void testGetUserTodos() {
        User user = new User();
        user.setId(1L);

        Todo todo = new Todo();
        todo.setTitle("Test title");
        todo.setDescription("Test description");
        todo.setUser(user);

        user.setTodo(Set.of(todo));

        when(userRepository.findById(anyLong())).thenReturn(Optional.of(user));

        List<TodoDTO> todos = todoService.getUserTodos(user);

        assertEquals(1, todos.size());
        assertEquals("Test title", todos.get(0).title());
        assertEquals("Test description", todos.get(0).description());
    }

    @Test
    void testGetUserTodosWhenUserNotFound() {
        User user = new User();
        user.setId(1L);

        when(userRepository.findById(anyLong())).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> todoService.getUserTodos(user));
    }

    @Test
    void testCreateTodo() {
        User user = new User();

        user.setId(1L);
        when(userRepository.findById(anyLong())).thenReturn(Optional.of(user));

        CreateTodoDTO createTodoDTO = new CreateTodoDTO("Test title", "Test description");
        todoService.createTodo(user, createTodoDTO);

        verify(todoRepository, times(1)).save(any(Todo.class));
    }

    @Test
    void testUpdateTodo() {
        Todo todo = new Todo();
        todo.setId(1L);
        todo.setTitle("Old title");
        todo.setDescription("Old description");

        when(todoRepository.findById(anyLong())).thenReturn(Optional.of(todo));

        UpdateTodoDTO updateTodoDTO = new UpdateTodoDTO("New title", "New description");
        todoService.updateTodo(1L, updateTodoDTO);

        verify(todoRepository, times(1)).save(any(Todo.class));
    }

    @Test
    void testDeleteTodo() {
        Todo todo = new Todo();
        todo.setId(1L);

        when(todoRepository.findById(anyLong())).thenReturn(Optional.of(todo));

        todoService.deleteTodo(1L);

        verify(todoRepository, times(1)).delete(any(Todo.class));
    }

    @Test
    void testCreateTodoWhenUserNotFound() {
        User user = new User();
        user.setId(1L);
        when(userRepository.findById(anyLong())).thenReturn(Optional.empty());

        CreateTodoDTO createTodoDTO = new CreateTodoDTO("Test title", "Test description");

        assertThrows(RuntimeException.class, () -> todoService.createTodo(user, createTodoDTO));

        verify(todoRepository, never()).save(any(Todo.class));
    }

    @Test
    void testUpdateTodoWhenTodoNotFound() {
        UpdateTodoDTO updateTodoDTO = new UpdateTodoDTO("New title", "New description");

        when(todoRepository.findById(anyLong())).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> todoService.updateTodo(1L, updateTodoDTO));

        verify(todoRepository, never()).save(any(Todo.class));
    }

    @Test
    void testDeleteTodoWhenTodoNotFound() {
        when(todoRepository.findById(anyLong())).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> todoService.deleteTodo(1L));

        verify(todoRepository, never()).delete(any(Todo.class));
    }
}
