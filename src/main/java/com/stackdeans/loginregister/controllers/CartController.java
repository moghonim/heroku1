package com.stackdeans.loginregister.controllers;

import com.stackdeans.loginregister.models.Cart;
import com.stackdeans.loginregister.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/save")
    public ResponseEntity<?> saveIntoCartAfterCheckOut(@Valid @RequestBody Cart cart) {
        return cartService.saveIntoCartAfterCheckOut(cart);
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<?> deleteCart(@PathVariable Long id) {
        return cartService.deleteCart(id);
    }

}
