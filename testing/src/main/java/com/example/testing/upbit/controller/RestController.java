package com.example.testing.upbit.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class RestController {

    @ExceptionHandler
    public String errorHandler(Exception e){
        return "RestControllerAdvice :" + e.getMessage();
    }
}
