package com.takeo.dao;


import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.User;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CartDao {


    private String name;
    private String description;
    private double price;
    private int qty;
    private int userId;


}