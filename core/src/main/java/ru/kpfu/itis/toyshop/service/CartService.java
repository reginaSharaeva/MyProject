package ru.kpfu.itis.toyshop.service;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.toyshop.domain.Cart;
import ru.kpfu.itis.toyshop.repository.CartRepository;
import ru.kpfu.itis.toyshop.repository.GoodRepository;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Регина on 11.03.2016.
 */
@Service
public class CartService {
    /**
     * Добавление товара в корзину
     */

    @Autowired
    private CartRepository cartRepository;

    public List<Cart> getAllCarts() {
        return cartRepository.getAllCarts();
    }

    public void addInCart(Long goodId, Long userId) {
        cartRepository.addInCart(goodId, userId);
    }
}


