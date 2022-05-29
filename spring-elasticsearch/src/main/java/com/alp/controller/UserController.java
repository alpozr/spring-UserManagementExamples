package com.alp.controller;

import com.alp.model.User;
import com.alp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.Calendar;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserRepository userRepository;

    @PostConstruct
    public void init(){
        User user=new User();
        user.setAd("Alp");
        user.setSoyad("OZER");
        user.setId("L0001");
        userRepository.save(user);
    }

    @GetMapping("/{search}")
    public  ResponseEntity<List<User>> getUser(@PathVariable String search){
     List<User>users=userRepository.getByCustomQuery(search);
     return ResponseEntity.ok(users);
    }
}
