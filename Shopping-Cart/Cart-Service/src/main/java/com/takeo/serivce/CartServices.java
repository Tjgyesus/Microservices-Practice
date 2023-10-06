package com.takeo.serivce;

import com.takeo.dao.CartDao;
import com.takeo.entity.Cart;

import java.util.List;
import java.util.Optional;

public interface CartServices {
public Cart registerCart  (CartDao cartDao);
public List<Cart> getCart();
public Optional<Cart> getCartById(int id);
public List <Cart> findCartByUserId(int userId);
}
