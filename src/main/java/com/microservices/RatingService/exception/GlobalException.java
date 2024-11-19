package com.microservices.RatingService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.microservices.RatingService.payload.ApiResponse;

@ControllerAdvice
public class GlobalException {

    @ExceptionHandler
    public ResponseEntity<ApiResponse> handelResponseEntity(NoRecordFoundException ex) {
        String message = ex.getMessage();
        ApiResponse response = ApiResponse.builder().message(message).success(false).status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

}
