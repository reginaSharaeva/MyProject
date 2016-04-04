package ru.kpfu.itis.toyshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.toyshop.domain.Cart;
import ru.kpfu.itis.toyshop.domain.Good;
import ru.kpfu.itis.toyshop.domain.User;
import ru.kpfu.itis.toyshop.repository.CartRepository;
import ru.kpfu.itis.toyshop.repository.GoodRepository;
import ru.kpfu.itis.toyshop.repository.UserRepository;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Regina on 11.03.2016.
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
        Cart cart = cartRepository.getCartByUserAndGood(good, user);
        if (cart == null) {
            cartRepository.saveCart(good, user);
        } else {
            cartRepository.updateCount(cart);
        }
    }

    public BigDecimal getTotalAmount(List<Cart> carts) {
        Long totalAmount = 0L;
        Cart cart;
        Long price;
        Long count;
        for (int i = 0; i < carts.size(); i++) {
            cart = cartRepository.getCartById(carts.get(i).getId());
            price = cart.getGoods().getPrice().longValue();
            count = cart.getCount();
            totalAmount += price*count;
        }
        return new BigDecimal(totalAmount);
    }

    public Cart getCartById(Long cartId) {
        return cartRepository.getCartById(cartId);
    }

    public void doCountLess(Cart cart) {
        cartRepository.doCountLess(cart);
    }

    public void doCountMore(Cart cart) {
        cartRepository.updateCount(cart);
    }

    public void goodRemove(Long cartId) {
        cartRepository.cartRemove(cartId);
    }
}


