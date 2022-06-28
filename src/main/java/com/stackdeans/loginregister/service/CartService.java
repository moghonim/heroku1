package com.stackdeans.loginregister.service;

import com.stackdeans.loginregister.models.Cart;
import com.stackdeans.loginregister.payload.response.MessageResponse;
import com.stackdeans.loginregister.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    public ResponseEntity<?> saveIntoCartAfterCheckOut(Cart cart) {
        cartRepository.save(cart);
        return ResponseEntity.ok(new MessageResponse("products in cart saved successfully!"));
    }

    public ResponseEntity<?> deleteCart(Long id) {
        cartRepository.deleteById(id);
        return ResponseEntity.ok(new MessageResponse("products in cart saved successfully!"));
    }
}
