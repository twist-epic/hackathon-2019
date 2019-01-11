package com.tgt.epic.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class DefaultController {

    @GetMapping()
    public ResponseEntity defaultRequest() {
        return ResponseEntity.status(HttpStatus.OK).body("HELLO WORLD! Your application is working!");
    }
}
