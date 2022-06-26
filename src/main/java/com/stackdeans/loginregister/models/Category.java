package com.stackdeans.loginregister.models;

import javax.persistence.*;
import java.util.List;


@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @Column(name = "picture")
    private String picture;

    //    @OneToMany(mappedBy = "category")
//    private List<Product> products;
//
    @OneToMany(mappedBy = "category")
    private List<SubCategory> subCategories;

    public Category() {
    }


    public Category(Long id, String name, String picture, List<Category> children) {
        this.id = id;
        this.name = name;
        this.picture = picture;
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


    public void setName(String name) {
        this.name = name;
    }


    public String getPicture() {
        return picture;
    }


    public void setPicture(String picture) {
        this.picture = picture;
    }

    public List<SubCategory> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(List<SubCategory> subCategories) {
        this.subCategories = subCategories;
    }
}
