package com.takeo.repo;

import com.takeo.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartRepo extends JpaRepository<Cart, Integer> {
  List<Cart> findCartsByUserId(int userId);
}
