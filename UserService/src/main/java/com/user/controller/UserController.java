package com.user.controller;

import com.user.model.entity.User;
import com.user.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    UserService userService;
    public UserController(UserService userService){
        this.userService=userService;
    }

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody User user){
        String message=userService.createUser(user);
        return ResponseEntity.ok(message);
    }

    @GetMapping
    public ResponseEntity<String> getProtectedData() {
        return ResponseEntity.ok("This is protected data");
    }
}