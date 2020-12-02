package com.abhishek.SpringBootMongoDB.service;

import com.abhishek.SpringBootMongoDB.exception.TodoCollectionException;
import com.abhishek.SpringBootMongoDB.model.TodoDTO;

import javax.validation.ConstraintViolationException;
import java.util.List;

public interface TodoService {
    void createTodo(TodoDTO todo) throws ConstraintViolationException, TodoCollectionException;
    List<TodoDTO> getAllTodos();
    TodoDTO getSingleTodo(String id) throws TodoCollectionException;
    void updateTodo(String id, TodoDTO newTodo) throws ConstraintViolationException, TodoCollectionException;
    void deleteTodo(String id) throws TodoCollectionException;
}
