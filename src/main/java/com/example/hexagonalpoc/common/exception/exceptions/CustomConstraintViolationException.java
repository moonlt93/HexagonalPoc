package com.example.hexagonalpoc.common.exception.exceptions;


import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;

import java.util.Set;
import java.util.stream.Collectors;

public class CustomConstraintViolationException extends ConstraintViolationException {

    public CustomConstraintViolationException(
            String message, Set<? extends ConstraintViolation<?>> constraintViolations) {
        super(message, constraintViolations);
    }

    public CustomConstraintViolationException(Set<? extends ConstraintViolation<?>> constraintViolations) {
        this(constraintViolations != null ? toString(constraintViolations) : null, constraintViolations);
    }

    private static String toString(Set<? extends ConstraintViolation<?>> constraintViolations) {
        return constraintViolations.stream()
                .map(cv -> cv == null ? "null" : cv.getMessage())
                .collect(Collectors.joining("\n"));
    }
}
