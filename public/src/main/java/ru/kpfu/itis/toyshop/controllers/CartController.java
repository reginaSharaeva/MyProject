package ru.kpfu.itis.toyshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.kpfu.itis.toyshop.aspects.annotations.IncludeMenuList;
import ru.kpfu.itis.toyshop.domain.Cart;
import ru.kpfu.itis.toyshop.domain.Good;
import ru.kpfu.itis.toyshop.domain.User;
import ru.kpfu.itis.toyshop.service.CartService;
import ru.kpfu.itis.toyshop.service.GoodService;
import ru.kpfu.itis.toyshop.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Regina on 24.02.2016.
 */
@Controller
@RequestMapping(value = "/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private UserService userService;

    @Autowired
    private HttpSession session;

    @Autowired
    private HttpServletRequest request;


    /**
     * Отображение корзины
     *
     * @return
     */
    @IncludeMenuList
    @RequestMapping(method = RequestMethod.GET)
    public String renderCart() {
        List<Cart> carts;
        String login = (String) session.getAttribute("userLogin");
        if (login == null) {
            carts = (List<Cart>) session.getAttribute("allCarts");
            session.setAttribute("allCarts", carts);
        } else {
            User user = userService.getUserByLogin(login);
            carts = cartService.getCartByUser(user);
            request.setAttribute("allCarts", carts);
        }
        session.setAttribute("totalAmount", cartService.getTotalAmount(carts));
        session.setAttribute("totalCount", cartService.getTotalCount(carts));

        return "cartPage";
    }

    /**
     * Добавление товара в корзину
     *
     * @param goodId id товара
     */
    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addInCart(Long goodId) {
        List<Cart> carts;
        String login = (String) session.getAttribute("userLogin");
        if (login == null) {
            carts = (List<Cart>) session.getAttribute("allCarts");
            carts = cartService.addInCart(carts, goodId);
            session.setAttribute("allCarts", carts);
        } else {
            User user = userService.getUserByLogin(login);
            cartService.addInCart(goodId, user);
        }
        return "ok";
    }

    @IncludeMenuList
    @RequestMapping(value = "/less", method = RequestMethod.POST)
    public String countLess(Long goodId) {
        List<Cart> carts;
        Cart cart;
        String login = (String) session.getAttribute("userLogin");
        if (login == null) {
            carts = (List<Cart>) session.getAttribute("allCarts");
            cart = cartService.getCartByGood(carts, goodId);
            if (cart.getCount() >= 1) {
                carts = cartService.doCountLess(carts, cart);
            }
            session.setAttribute("allCarts", carts);
        } else {
            User user = userService.getUserByLogin(login);
            carts = cartService.getCartByUser(user);
            cart = cartService.getCartByUserAndGood(user, goodId);
            if (cart.getCount() >= 1) {
                cartService.doCountLess(cart);
                for (Cart c : carts) {
                    if (c.equals(cart)) {
                        c.setCount(c.getCount() - 1);
                    }
                }
            }
            request.setAttribute("allCarts", carts);
        }

        session.setAttribute("totalAmount", cartService.getTotalAmount(carts));
        session.setAttribute("totalCount", cartService.getTotalCount(carts));
        return "cartPage";
    }

    @IncludeMenuList
    @RequestMapping(value = "/more", method = RequestMethod.POST)
    public String countMore(Long goodId) {
        List<Cart> carts;
        Cart cart;
        String login = (String) session.getAttribute("userLogin");
        if (login == null) {
            carts = (List<Cart>) session.getAttribute("allCarts");
            cart = cartService.getCartByGood(carts, goodId);
            if (cart.getCount() < 12) {
                carts = cartService.doCountMore(carts, cart);
            }
            session.setAttribute("allCarts", carts);
        } else {
            User user = userService.getUserByLogin(login);
            carts = cartService.getCartByUser(user);
            cart = cartService.getCartByUserAndGood(user, goodId);
            if (cart.getCount() < 12) {
                cartService.doCountMore(cart);
                for (Cart c : carts) {
                    if (c.equals(cart)) {
                        c.setCount(c.getCount() + 1);
                    }
                }
            }
            request.setAttribute("allCarts", carts);
        }
        session.setAttribute("totalAmount", cartService.getTotalAmount(carts));
        session.setAttribute("totalCount", cartService.getTotalCount(carts));
        return "cartPage";
    }

    @IncludeMenuList
    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public String goodRemove(Long goodId) {
        List<Cart> carts;
        String login = (String) session.getAttribute("userLogin");
        if (login == null) {
            carts = (List<Cart>) session.getAttribute("allCarts");
            carts = cartService.goodRemoveByGood(carts, goodId);
            session.setAttribute("allCarts", carts);
        } else {
            User user = userService.getUserByLogin(login);
            cartService.goodRemoveByUserAndGood(user, goodId);
            carts = cartService.getCartByUser(user);
            request.setAttribute("allCarts", carts);
        }
        session.setAttribute("totalAmount", cartService.getTotalAmount(carts));
        session.setAttribute("totalCount", cartService.getTotalCount(carts));
        return "cartPage";
    }
}
