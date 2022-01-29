package com.example.chatms.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin
public class UserController {


//    @Autowired
//    UserStorage store;
    
    @GetMapping("/registration/{userName}")
    public ResponseEntity<Void> register(@PathVariable String userName) {
        System.out.println("handling register user request: " + userName);
        try {
//            store.setUser(userName);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }

//    @GetMapping("/fetchAllUsers")
//    public Set<String> fetchAll() {
//        return store.getUsers();
//    }
}
