package com.alura.ScreenMatch.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    private final String GENERIC = "Erro no servidor.Contacte o administrador!";

    @ExceptionHandler(GenericNotFoundException.class)
    public ResponseEntity<ResponseError> notFoundException(GenericNotFoundException ex){
        ResponseError response = new ResponseError(
                ex.getMessage(),
                HttpStatus.NOT_FOUND,
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseError> genericException(Exception ex){
        ResponseError response = new ResponseError(
                GENERIC,
                HttpStatus.INTERNAL_SERVER_ERROR,
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ResponseError> genericRuntimeException(RuntimeException ex){
        ResponseError response = new ResponseError(
                GENERIC,
                HttpStatus.INTERNAL_SERVER_ERROR,
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
}
