package com.tgt.epic.controller;

import com.tgt.epic.service.EpicHackathonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class EpicHackathonController {

    @Autowired
    private EpicHackathonService epicHackathonService;

    @GetMapping(path = "/testget")
    public ResponseEntity testGetRequest() {
        return ResponseEntity.status(HttpStatus.OK).body("HELLO WORLD");
    }

    @PutMapping(path = "/testput")
    public ResponseEntity testPutRequest(@RequestBody String input) {
        return ResponseEntity.status(HttpStatus.OK).body("HELLO WORLD");
    }

    @PostMapping(path = "/testpost")
    public ResponseEntity testPostRequest(@RequestBody String input) {
        return ResponseEntity.status(HttpStatus.OK).body("HELLO WORLD");
    }


}
