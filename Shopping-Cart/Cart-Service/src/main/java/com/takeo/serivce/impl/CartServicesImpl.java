package com.takeo.serivce.impl;

import com.takeo.dao.CartDao;
import com.takeo.entity.Cart;
import com.takeo.repo.CartRepo;
import com.takeo.serivce.CartServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartServicesImpl implements CartServices {
    @Autowired
    private CartRepo cartRepo;

    @Override
    public Cart registerCart(CartDao cartDao) {
        Cart cart = new Cart();
        cart.setName(cartDao.getName());
        cart.setDescription(cartDao.getDescription());
        cart.setQty(cartDao.getQty());
        cart.setPrice(cartDao.getPrice());
        cart.setUserId(cartDao.getUserId());
        Cart saveCart = cartRepo.save(cart);
        return saveCart;
    }

    @Override
    public List<Cart> getCart() {
        List<Cart> cartList = cartRepo.findAll();

        return cartList;
    }

    @Override
    public Optional<Cart> getCartById(int id) {
        Optional<Cart> getCartById = cartRepo.findById(id);
        return getCartById;
    }


    public List <Cart> findCartByUserId(int userId) {
       List<Cart> cartByUserId = cartRepo.findCartsByUserId(userId);
        return cartByUserId;
    }
}
