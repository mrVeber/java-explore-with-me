package ru.practicum.ewm.model.errors;

public class ValidationException extends RuntimeException {
    public ValidationException(String message) {
        super(message);
    }
}
