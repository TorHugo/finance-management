package com.torhugo.finance_management.exception;

import com.torhugo.finance_management.exception.impl.DataBaseException;
import com.torhugo.finance_management.exception.impl.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    static private HttpStatus notFound = HttpStatus.NOT_FOUND;
    static private HttpStatus badRequest = HttpStatus.BAD_REQUEST;

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> entityNotFound(ResourceNotFoundException exception,
                                                        HttpServletRequest request){
        StandardError err = new StandardError();
        err.setTimestamp(Instant.now());
        err.setStatus(notFound.value());
        err.setError("Resource not found.");
        err.setMessage(exception.getMessage());
        err.setPath(request.getRequestURI());

        return ResponseEntity.status(notFound).body(err);
    }

    @ExceptionHandler(DataBaseException.class)
    public ResponseEntity<StandardError> dataBase(DataBaseException exception,
                                                  HttpServletRequest request){
        StandardError err = new StandardError();

        err.setTimestamp(Instant.now());
        err.setStatus(badRequest.value());
        err.setError("DataBase Exception.");
        err.setMessage(exception.getMessage());
        err.setPath(request.getRequestURI());

        return ResponseEntity.status(badRequest).body(err);
    }
}
