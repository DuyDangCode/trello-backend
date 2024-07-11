package com.duydangcode.trello_spring.core;

import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ErrorEntity> handleAllException(Exception ex, WebRequest request) {
    var newError = new ErrorEntity(HttpStatus.INTERNAL_SERVER_ERROR.toString(), ex.getMessage());
    return new ResponseEntity<>(newError, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(BadRequestException.class)
  public ResponseEntity<ErrorEntity> handleBadRequestException(Exception ex, WebRequest request) {
    var newError = new ErrorEntity(HttpStatus.BAD_REQUEST.toString(), ex.getMessage());
    return new ResponseEntity<>(newError, HttpStatus.BAD_REQUEST);
  }

  @Override
  @Nullable
  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
      HttpHeaders headers,
      HttpStatusCode status, WebRequest request) {
    var newError = new ErrorEntity(HttpStatus.BAD_REQUEST.toString(), ex.getFieldError().getDefaultMessage());
    return new ResponseEntity<>(newError, HttpStatus.BAD_REQUEST);
  }
}
