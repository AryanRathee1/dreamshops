package com.aryan.dreamshops.service.cart;

import com.aryan.dreamshops.dto.CartDto;
import com.aryan.dreamshops.model.Cart;
import com.aryan.dreamshops.model.User;

import java.math.BigDecimal;

public interface ICartService {
    Cart getCart(Long id);
    void clearCart(Long id);
    BigDecimal getTotalPrice(Long id);

    Cart initializeNewCart(User user);

    Cart getCartByUserId(Long userId);

    CartDto convertToDto(Cart cart);
}
