package com.alp.controller;

import com.alp.repository.UserRepository;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController//Web arayüzüne istek atacak
@RequestMapping("/user")//pathimizi verdik
public class UserApi {

    @Autowired//sinifimizdan nesne olusturduk.
    private UserRepository userRepository;

     @PostConstruct
     public void init(){
         User user = new User();
         user.setFirstName("Alp");
         user.setLastName("OZER");
         
         userRepository.save(user);
     }

    @PostMapping//kayıt islemi yapacak post mapping actık
    public ResponseEntity<User> addUser(@RequestBody User user){
        return ResponseEntity.ok(userRepository.save(user));
    }
    @GetMapping
    public ResponseEntity<List<User>> listAll(User user){
        return ResponseEntity.ok(userRepository.findAll());
    }
}
