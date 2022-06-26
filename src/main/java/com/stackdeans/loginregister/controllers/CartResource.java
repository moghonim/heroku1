package com.stackdeans.loginregister.controllers;

import com.stackdeans.loginregister.models.Cart;
import com.stackdeans.loginregister.payload.response.MessageResponse;
import com.stackdeans.loginregister.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/cart")
public class CartResource {

    @Autowired
    CartRepository cartRepository;

    @PostMapping("/save")
    public ResponseEntity<?> saveIntoCartAfterCheckOut(@Valid @RequestBody Cart cart) {
        cartRepository.save(cart);
        return ResponseEntity.ok(new MessageResponse("products in cart saved successfully!"));
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<?> deleteCart(@PathVariable Long id) {
        cartRepository.deleteById(id);
        return ResponseEntity.ok(new MessageResponse("products in cart saved successfully!"));
    }

}
