package com.takeo.entity;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

public record Cart(int id, int userId, String name, String description, double price, int qty) {
}


