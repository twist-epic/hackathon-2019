package com.tgt.epic.controller;

import com.tgt.epic.domain.User;
import com.tgt.epic.service.EpicHackathonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping(path = "/get_all_users")
    public ResponseEntity getAllUsers() {
        List<User> users = epicHackathonService.getAllUsers();
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }


    @PostMapping(path = "/add_user")
    public ResponseEntity addUser(@RequestBody User user) {
        if(epicHackathonService.addUser(user))
            return ResponseEntity.status(HttpStatus.OK).body("User successfully added");
        else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Adding user failed. Does this user already exist?");
        }
    }


}
