package com.epam.wca.todo.todo_list.repository;

import com.epam.wca.todo.todo_list.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
