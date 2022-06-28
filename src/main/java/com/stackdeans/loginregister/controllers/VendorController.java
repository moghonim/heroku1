package com.stackdeans.loginregister.controllers;

import com.stackdeans.loginregister.models.Product;
import com.stackdeans.loginregister.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vendor")
public class VendorController {
    @Autowired
    private VendorService vendorService;

    @PostMapping(value = "/addnewproduct")
    @PreAuthorize("hasRole('VENDOR') or hasRole('ADMIN')")
    public List<Product> persist(@RequestBody final Product product) {
        return vendorService.persist(product);
    }

    @DeleteMapping(value = "/delete")
    @PreAuthorize("hasRole('VENDOR') or hasRole('ADMIN')")
    public List<Product> delete(@PathVariable Long id) {
        return vendorService.delete(id);
    }
    @PutMapping(value = "/put/{id}")
    @PreAuthorize("hasRole('VENDOR') or hasRole('ADMIN')")
    public List<Product> put(@PathVariable Long id, @RequestBody Product product) {
        return vendorService.put(id, product);
    }
}
