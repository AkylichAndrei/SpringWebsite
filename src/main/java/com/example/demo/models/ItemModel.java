package com.example.demo.models;

import com.example.demo.enums.Type;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "Item_model")
@Data
public class ItemModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private String price;

    @Column(name = "disc")
    private String disc;


    @Column(name = "image")
    private String image;

    @Enumerated
    @Column(name = "type")
    Type type;


}
