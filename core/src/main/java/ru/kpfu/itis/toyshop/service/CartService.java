package ru.kpfu.itis.toyshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.toyshop.domain.Cart;
import ru.kpfu.itis.toyshop.domain.Good;
import ru.kpfu.itis.toyshop.domain.User;
import ru.kpfu.itis.toyshop.repository.CartRepository;
import ru.kpfu.itis.toyshop.repository.GoodRepository;
import ru.kpfu.itis.toyshop.repository.UserRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
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
     * Добавление товара в корзину
     */
    public List<Cart> addInCart(List<Cart> carts, Long goodId) {
        Good good = goodRepository.getGoodById(goodId);
        if (carts == null) {
            carts = new ArrayList<>();
        }
        boolean contains = false;
        for (Cart cart: carts) {
            if (cart.getGoods().equals(good)) {
                Long count = cart.getCount() + 1;
                cart.setCount(count);
                contains = true;
            }
        }
        if (!contains) {
            carts.add(new Cart(1L, good));
        }
        return carts;
    }

    public void addInCart(Long goodId, User user) {
        Good good = goodRepository.getGoodById(goodId);
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
        if (carts != null) {
            for (int i = 0; i < carts.size(); i++) {
                cart = carts.get(i);
                price = cart.getGoods().getPrice().longValue();
                count = cart.getCount();
                totalAmount += price * count;
            }
        }
        return new BigDecimal(totalAmount);
    }

    public Long getTotalCount(List<Cart> carts) {
        Long totalCount = 0L;
        Cart cart;
        if (carts != null) {
            for (int i = 0; i < carts.size(); i++) {
                cart = carts.get(i);
                totalCount += cart.getCount();
            }
        }
        return totalCount;
    }

    public Cart getCartByUserAndGood(User user, Long goodId) {
        Good good = goodRepository.getGoodById(goodId);
        return cartRepository.getCartByUserAndGood(good, user);
    }

    public Cart getCartByGood(List<Cart> carts, Long goodId) {
        for (Cart cart: carts) {
            if (cart.getGoods().getId().equals(goodId)) {
                return cart;
            }
        }
        return null;
    }

    public List<Cart> getCartByUser(User user) {
        return cartRepository.getCartByUser(user);
    }

    public List<Cart> doCountLess(List<Cart> carts, Cart cart) {
        for (Cart c: carts) {
            if (c.equals(cart)) {
                Long count = c.getCount();
                c.setCount(count - 1);
            }
        }
        return carts;
    }

    public void doCountLess(Cart cart) {
        cartRepository.doCountLess(cart);
    }

    public List<Cart> doCountMore(List<Cart> carts, Cart cart) {
        for (Cart c: carts) {
            if (c.equals(cart)) {
                Long count = c.getCount();
                c.setCount(count + 1);
            }
        }
        return carts;
    }

    public void doCountMore(Cart cart) {
        cartRepository.updateCount(cart);
    }

    public List<Cart> goodRemoveByGood(List<Cart> carts, Long goodId) {
        for (int i = 0; i < carts.size(); i++) {
            if (carts.get(i).getGoods().getId().equals(goodId)) {
                carts.remove(i);
            }
        }
        return carts;
    }

    public void deleteCart(Cart cart) {
        cartRepository.deleteCart(cart.getId());
    }

    public void goodRemoveByUserAndGood(User user, Long goodId) {
        Cart cart = getCartByUserAndGood(user, goodId);
        cartRepository.cartRemove(cart);
    }
}


