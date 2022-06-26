package com.stackdeans.loginregister.service;

import com.stackdeans.loginregister.models.Product;
import com.stackdeans.loginregister.models.WishList;
import com.stackdeans.loginregister.repository.WishListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WishListService {
    @Autowired
    WishListRepository wishListRepository;

    public void save(Product product) {
        WishList wishList = new WishList();
        wishList.setProduct(product);
        wishListRepository.save(wishList);
    }

    public void delete(Product product) {
        wishListRepository.deleteById(product.getId());
    }
}
