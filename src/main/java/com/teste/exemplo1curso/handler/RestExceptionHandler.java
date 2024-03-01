package com.teste.exemplo1curso.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.teste.exemplo1curso.model.error.ErrorMessage;
import com.teste.exemplo1curso.model.exception.ResourceNotFoundException;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler{

    private static final Logger logger = LoggerFactory.getLogger(RestExceptionHandler.class);
    static {
        logger.info("eaeEEEEEEEEEEEEE");
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException ex) {

        ErrorMessage error = new ErrorMessage("Not Found", HttpStatus.NOT_FOUND.value(), ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
