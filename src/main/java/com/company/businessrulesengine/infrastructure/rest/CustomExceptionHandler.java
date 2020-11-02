package com.company.businessrulesengine.infrastructure.rest;

import com.company.businessrulesengine.spel.InvalidExpressionException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
    
    public static final String INVALID_EXPRESSION = "Invalid expression";

    @ExceptionHandler(InvalidExpressionException.class)
    public final ResponseEntity<Object> handleInvalidExpressionException(Exception exception, WebRequest request) {

        return new ResponseEntity<>(INVALID_EXPRESSION, HttpStatus.BAD_REQUEST);
    }
}