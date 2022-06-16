package com.alp.apitutorial;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@RestController
@RequestMapping(("/users"))
@Api(value = "Users API documents")
public class UserApi {
   private List<UserDto> users= new ArrayList<>();



    @PostConstruct
   public void init(){
       users.add(new UserDto(1,"alpadam1",1));
       users.add(new UserDto(2,"alpadam2",22));
       users.add(new UserDto(3,"alpadam3",333));
   }

    @PostMapping("post")//You can add new user via postman
    @ApiOperation(value = "New user add method", notes = "This method create new user")
    public ResponseEntity<UserDto> save(@RequestBody UserDto user){
        users.add(user);
        return ResponseEntity.ok(user);
    }
    @GetMapping// you can list all users in init first
    @ApiOperation(value = "List all users", notes = "This method list all user")
    public ResponseEntity<List<UserDto>> listAll(){

        return ResponseEntity.ok(users);
    }

    @GetMapping(value = "/{id}")//you can delete your users with user's id (HİNT: use getmapping to check id's first)
    public ResponseEntity<String> deleteOrder(@PathVariable int id) {

        boolean deleted = users.removeIf(n -> (n.getId()==id));
        if(!deleted){
            return ResponseEntity.ok("id doesnt find : "+ id);
        }
        return ResponseEntity.ok("You deleted : "+ id);
    }
    }


