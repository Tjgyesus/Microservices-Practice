package com.takeo.controller;

import com.takeo.client.CartClient;
import com.takeo.entity.Cart;
import com.takeo.service.UserServiceImpl;
import com.takeo.dao.UserDao;
import com.takeo.entity.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/shopper")
public class UserController {

    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private CartClient cartClient;

    @PostMapping("/signup")
    public ResponseEntity<User> registerUser(@RequestBody @Valid UserDao userDao){
        return new ResponseEntity<>(userService.registerUser(userDao), HttpStatus.CREATED);
    }
    @GetMapping("/fetchAll")
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok(userService.getUsers());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<User>> findUserById(@PathVariable("id") int id){
        return ResponseEntity.ok(userService.findById(id));
    }

    @GetMapping("/with-cart")
    public ResponseEntity<List<User>> getAllUsersWithCart(){
        return ResponseEntity.ok(userService.getAllUsersWithCart());
    }

}
