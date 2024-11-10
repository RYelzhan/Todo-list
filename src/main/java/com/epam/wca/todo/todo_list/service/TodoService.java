package com.epam.wca.todo.todo_list.service;

import com.epam.wca.todo.todo_list.dto.CreateTodoDTO;
import com.epam.wca.todo.todo_list.dto.TodoDTO;
import com.epam.wca.todo.todo_list.dto.UpdateTodoDTO;
import com.epam.wca.todo.todo_list.entity.Todo;
import com.epam.wca.todo.todo_list.entity.User;
import com.epam.wca.todo.todo_list.repository.TodoRepository;
import com.epam.wca.todo.todo_list.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;
    private final UserRepository userRepository;

    @Transactional
    public void createTodo(User authenticatedUser, CreateTodoDTO createTodoDTO) {
        User user = userRepository.findById(authenticatedUser.getId())
                .orElseThrow(() -> new RuntimeException("User not found."));

        Todo todo = new Todo();

        todo.setTitle(createTodoDTO.title());
        todo.setDescription(createTodoDTO.description());

        todo.setUser(user);

        todoRepository.save(todo);
    }

    @Transactional
    public List<TodoDTO> getUserTodos(User authenticatedUser) {
        User user = userRepository.findById(authenticatedUser.getId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        return user.getTodo()
                .stream()
                .map(todo -> new TodoDTO(todo.getTitle(), todo.getDescription()))
                .toList();

    }

    @Transactional
    public void updateTodo(long id, UpdateTodoDTO updateTodoDTO) {
        Todo existingTodo = todoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Todo not found with id: " + id));

        existingTodo.setTitle(updateTodoDTO.title());
        existingTodo.setDescription(updateTodoDTO.description());

        todoRepository.save(existingTodo);
    }

    @Transactional
    public void deleteTodo(long id) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Todo not found with id: " + id));
        todoRepository.delete(todo);
    }
}
