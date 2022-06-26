package com.stackdeans.loginregister.models;

import javax.persistence.*;


@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @ManyToOne
    private WishList wishList;


    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "weight", nullable = false)
    private double weight;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "picture1")
    private String picture1;

    @Column(name = "picture2")
    private String picture2;

    @Column(name = "picture3")
    private String picture3;

//    @ManyToOne
//    private Category category;

    @ManyToOne
    private SubCategory subCategory;

    @ManyToOne
    private Cart cart;

    @Column(name = "sellings", nullable = false)
    private int noOfSellings;


    public Product() {
    }

    public Product(Long id, WishList wishList, String name, String description, double weight, double price, String picture1, String picture2, String picture3, SubCategory subCategory, Cart cart, int noOfSellings) {
        this.id = id;
        this.wishList = wishList;
        this.name = name;
        this.description = description;
        this.weight = weight;
        this.price = price;
        this.picture1 = picture1;
        this.picture2 = picture2;
        this.picture3 = picture3;
        this.subCategory = subCategory;
        this.cart = cart;
        this.noOfSellings = noOfSellings;
    }

    public int getNoOfSellings() {
        return noOfSellings;
    }

    public void setNoOfSellings(int noOfSellings) {
        this.noOfSellings = noOfSellings;
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public WishList getWishList() {
        return wishList;
    }

    public void setWishList(WishList wishList) {
        this.wishList = wishList;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }


    public String getPicture1() {
        return picture1;
    }


    public void setPicture1(String picture1) {
        this.picture1 = picture1;
    }

    public String getPicture2() {
        return picture2;
    }

    public void setPicture2(String picture2) {
        this.picture2 = picture2;
    }

    public String getPicture3() {
        return picture3;
    }

    public void setPicture3(String picture3) {
        this.picture3 = picture3;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public SubCategory getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(SubCategory subCategory) {
        this.subCategory = subCategory;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
