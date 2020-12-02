package com.abhishek.SpringBootMongoDB.service;

import com.abhishek.SpringBootMongoDB.exception.TodoCollectionException;
import com.abhishek.SpringBootMongoDB.model.TodoDTO;
import com.abhishek.SpringBootMongoDB.repository.TodoRepostory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TodoServiceImpl implements TodoService{

    @Autowired
    private TodoRepostory todoRepo;

    @Override
    public void createTodo(TodoDTO todo) throws ConstraintViolationException, TodoCollectionException {
        Optional<TodoDTO> todoOptional = todoRepo.findByTodo(todo.getTodo());
        if(todoOptional.isPresent()){
            throw new TodoCollectionException(TodoCollectionException.TodoAlreadyExists());
        }else{
            todo.setCreatedAt(new Date(System.currentTimeMillis()));
            todoRepo.save(todo);
        }
    }

    @Override
    public List<TodoDTO> getAllTodos() {
        List<TodoDTO> todoList = todoRepo.findAll();
        if(todoList.isEmpty()){
            return new ArrayList<TodoDTO>();
        }
        return todoList;
    }

    @Override
    public TodoDTO getSingleTodo(String id) throws TodoCollectionException {
        Optional<TodoDTO> todoOptional = todoRepo.findById(id);
        if(todoOptional.isPresent()){
            return todoOptional.get();
        }
        throw new TodoCollectionException(TodoCollectionException.NotFoundException(id));
    }

    @Override
    public void updateTodo(String id, TodoDTO newTodo) throws ConstraintViolationException, TodoCollectionException {
        Optional<TodoDTO> todo = todoRepo.findById(id);
        if(todo.isEmpty())throw new TodoCollectionException(TodoCollectionException.NotFoundException(id));
        TodoDTO oldTodo = todo.get();
        String todoId = oldTodo.getId();
        Date createdAt = oldTodo.getCreatedAt();
        BeanUtils.copyProperties(newTodo,oldTodo);
        oldTodo.setId(todoId);
        oldTodo.setCreatedAt(createdAt);
        oldTodo.setUpdatedAt(new Date(System.currentTimeMillis()));
        todoRepo.save(oldTodo);
    }

    @Override
    public void deleteTodo(String id) throws TodoCollectionException {
        Optional<TodoDTO> todo = todoRepo.findById(id);
        if(todo.isPresent()){
            todoRepo.deleteById(id);
        }else{
            throw new TodoCollectionException(TodoCollectionException.NotFoundException(id));
        }
    }
}
