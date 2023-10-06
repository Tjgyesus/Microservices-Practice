package com.takeo.client;

import com.takeo.entity.Cart;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import java.util.List;

@HttpExchange
public interface CartClient {

    @GetExchange("/cart/shopper/{userId}")
    public List<Cart> getCartbyUserId(@PathVariable("userId") int userId);
}
