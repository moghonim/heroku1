package com.stackdeans.loginregister.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    private Long id;

    private String name;

    private String description;

    private double weight;

    private double price;

    private String picture1;

    private String picture2;

    private String picture3;

    private SubCategory subCategory;

    private Cart cart;

    private int noOfSellings;
}
