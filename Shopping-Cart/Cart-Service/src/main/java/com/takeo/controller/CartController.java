package com.takeo.controller;


import com.takeo.dao.CartDao;
import com.takeo.entity.Cart;
import com.takeo.serivce.impl.CartServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartServicesImpl cartServices;

    @PostMapping("/addCart")
    public ResponseEntity<Cart> registerCart(@RequestBody CartDao cartDao){
        return new ResponseEntity<>(cartServices.registerCart(cartDao), HttpStatus.CREATED);
    }
    @GetMapping("/fetchAll")
    public ResponseEntity<List<Cart>> getCart(){
        return ResponseEntity.ok(cartServices.getCart());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Cart>> getCartbyId(@PathVariable("id") int id){
        return ResponseEntity.ok(cartServices.getCartById(id));
    }
    @GetMapping("/shopper/{userId}")
    public ResponseEntity<List<Cart>> getCartbyUserId(@PathVariable("userId") int userId){
        return ResponseEntity.ok(cartServices.findCartByUserId(userId));
    }


}
