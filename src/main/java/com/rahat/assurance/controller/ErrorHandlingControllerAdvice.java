package com.rahat.assurance.controller;

import com.rahat.assurance.constant.ErrorCodeEnum;
import com.rahat.assurance.exception.RecordNotFoundException;
import com.rahat.assurance.exception.InvalidStatusException;
import com.rahat.assurance.model.Error;
import com.rahat.assurance.model.ErrorResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ErrorHandlingControllerAdvice extends ResponseEntityExceptionHandler {

    private ResponseEntity handle(HttpStatusCode status, int code, String message) {
        return ResponseEntity.status(status)
                .body(ErrorResponse.builder()
                        .error(Error.builder()
                                .code(code)
                                .message(message)
                                .build())
                        .build());
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        return handle(status, 500, ex.getMessage());
    }

    @ExceptionHandler(RecordNotFoundException.class)
    protected ResponseEntity handle(RecordNotFoundException ex) {
        return handle(HttpStatus.BAD_REQUEST, ErrorCodeEnum.RECORD_NOT_FOUND.getCode(), ex.getMessage());
    }

    @ExceptionHandler(InvalidStatusException.class)
    protected ResponseEntity handle(InvalidStatusException ex) {
        return handle(HttpStatus.BAD_REQUEST, ErrorCodeEnum.INVALID_STATUS.getCode(), ex.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity handle(MethodArgumentNotValidException ex) {
        return handle(HttpStatus.BAD_REQUEST, ErrorCodeEnum.INVALID_DATA.getCode(), ex.getMessage());
    }
}
