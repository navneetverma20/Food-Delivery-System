package com.example.fooddelivery.model;

import javax.persistence.*;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String address;
    private String phoneNumber;
    
        // Default constructor
    public Restaurant() {}

    // Optional: Constructor with ID
    public Restaurant(Long id) {
        this.id = id;
    }


    // getters and setters
}
