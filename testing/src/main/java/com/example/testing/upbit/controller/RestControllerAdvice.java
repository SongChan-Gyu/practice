package com.example.testing.upbit.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@org.springframework.web.bind.annotation.RestControllerAdvice
public class RestControllerAdvice {

    @ExceptionHandler
    public String errorHandler(Exception e){
        return "RestControllerAdvice :" + e.getMessage();
    }
}
