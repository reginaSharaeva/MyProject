package ru.kpfu.itis.toyshop.service;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.toyshop.domain.Cart;
import ru.kpfu.itis.toyshop.domain.Good;
import ru.kpfu.itis.toyshop.domain.User;
import ru.kpfu.itis.toyshop.repository.CartRepository;
import ru.kpfu.itis.toyshop.repository.GoodRepository;
import ru.kpfu.itis.toyshop.repository.UserRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Регина on 11.03.2016.
 */
@Service
public class CartService {


    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private GoodRepository goodRepository;

    @Autowired
    private UserRepository userRepository;

    /**
     * Отображение товаров из корзины
     *
     * @return
     */
    public List<Cart> getAllCarts() {
        return cartRepository.getAllCarts();
    }

    /**
     * Добавление товара в корзину
     */
    public void addInCart(Long goodId, Long userId) {
        Good good = goodRepository.getGoodById(goodId);
        User user = userRepository.getUserById(userId);
        cartRepository.addInCart(good, user);
    }
}


