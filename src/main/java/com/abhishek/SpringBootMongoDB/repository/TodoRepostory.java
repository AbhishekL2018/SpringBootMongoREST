package com.abhishek.SpringBootMongoDB.repository;

import com.abhishek.SpringBootMongoDB.model.TodoDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TodoRepostory extends MongoRepository<TodoDTO,String> {

    @Query("{'todo': ?0}")
    Optional<TodoDTO> findByTodo(String todo);
    
}
