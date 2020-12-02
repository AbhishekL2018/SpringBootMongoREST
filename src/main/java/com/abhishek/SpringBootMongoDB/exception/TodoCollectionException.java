package com.abhishek.SpringBootMongoDB.exception;

public class TodoCollectionException extends Exception {

    public static final long serialVersionUID = 1L;

    public TodoCollectionException(String message) {
        super(message);
    }

    public static String NotFoundException(String id) {
        return "todo with " + id + " not found";
    }

    public static String TodoAlreadyExists() {
        return "todo with given name already exists";
    }
}
