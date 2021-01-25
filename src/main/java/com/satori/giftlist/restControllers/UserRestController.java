package com.satori.giftlist.restControllers;

import com.satori.giftlist.domain.Gift;
import com.satori.giftlist.domain.User;
import com.satori.giftlist.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserRestController {

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public ResponseEntity getAll(){
        List<User> userList = userService.getAll();
        if(userList != null){
            return new ResponseEntity<>(userList, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/user/{id}")
    public ResponseEntity getById(@PathVariable int id){
        User user = userService.getById(id);
        if(user != null){
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/user")
    public ResponseEntity create(@RequestBody User user){
        userService.create(user);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/user/{id}")
    public ResponseEntity update(@RequestBody User user, @PathVariable int id){
        if(userService.getById(id) != null){
            userService.update(id, user);
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).build();
        }
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity delete(@PathVariable int id){
        if(userService.getById(id) != null) {
            userService.delete(id);
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).build();
        }
    }
}
