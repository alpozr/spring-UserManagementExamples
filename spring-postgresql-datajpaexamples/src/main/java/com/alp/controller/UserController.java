package com.alp.controller;

import com.alp.apitutorial.UserDto;
import com.alp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping//kayıt islemi yapacak post mapping actık
    public ResponseEntity<UserDto> save(@RequestBody UserDto userDto){
        return ResponseEntity.ok(userService.save(userDto));
    }
    @GetMapping
    public ResponseEntity<List<UserDto>> listAll(UserDto userDto){
        return ResponseEntity.ok(userService.getAll());
    }
}

