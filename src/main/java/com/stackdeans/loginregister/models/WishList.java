package com.stackdeans.loginregister.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class WishList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column
    @OneToMany(mappedBy = "wishList")
    private List<Product> products;


    public WishList() {
    }

    public WishList(long id, List<Product> product) {
        this.id = id;
        this.products = product;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Product> getProduct() {
        return products;
    }

    public void setProduct(List<Product> product) {
        this.products = product;
    }
}