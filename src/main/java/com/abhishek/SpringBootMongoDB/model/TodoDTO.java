package com.abhishek.SpringBootMongoDB.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Document(collection = "todos")
public class TodoDTO {

    @Id
    private String id;
    @NotNull(message = "todo cannot be null")
    @NotEmpty(message = "todo cannot be empty")
    private String todo;
    @NotNull(message = "description cannot be null")
    @NotEmpty(message = "description cannot be empty")
    private String description;
    @NotNull(message = "completed cannot be null")
    private Boolean completed;
    private Date createdAt;
    private Date updatedAt;

    public TodoDTO() {
    }

    public TodoDTO(String id, String todo, String description, Boolean completed, Date createdAt, Date updatedAt) {
        this.id = id;
        this.todo = todo;
        this.description = description;
        this.completed = completed;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTodo() {
        return todo;
    }

    public void setTodo(String todo) {
        this.todo = todo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "TodoDTO{" +
                "id='" + id + '\'' +
                ", todo='" + todo + '\'' +
                ", description='" + description + '\'' +
                ", completed=" + completed +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
