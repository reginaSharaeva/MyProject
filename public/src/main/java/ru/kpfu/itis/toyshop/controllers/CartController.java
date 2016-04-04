package ru.kpfu.itis.toyshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.kpfu.itis.toyshop.domain.Cart;
import ru.kpfu.itis.toyshop.service.CartService;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Regina on 24.02.2016.
 */
@Controller
@RequestMapping(value = "/cart")
public class CartController {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private CartService cartService;


    /**
     *
     * Отображение корзины
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public String renderCart() {
        request.setAttribute("allCarts", cartService.getAllCarts());
        request.setAttribute("totalAmount",cartService.getTotalAmount(cartService.getAllCarts()));
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
        cartService.addInCart(goodId, (long) 1);
        request.setAttribute("goodInCart", true);
        return "ok";
    }

    @RequestMapping(value = "/less", method = RequestMethod.POST)
    public String countLess(@RequestParam(required = false) Long cartId) {
        Cart cart = cartService.getCartById(cartId);
        if (cart.getCount() >= 1) {
            cartService.doCountLess(cart);
        }
        request.setAttribute("allCarts", cartService.getAllCarts());
        request.setAttribute("totalAmount",cartService.getTotalAmount(cartService.getAllCarts()));
        return "cartPage";
    }

    @RequestMapping(value = "/more", method = RequestMethod.POST)
    public String countMore(@RequestParam(required = false) Long cartId) {
        Cart cart = cartService.getCartById(cartId);
        if (cart.getCount() < 20) {
            cartService.doCountMore(cart);

        }
        request.setAttribute("allCarts", cartService.getAllCarts());
        request.setAttribute("totalAmount",cartService.getTotalAmount(cartService.getAllCarts()));
        return "cartPage";
    }

    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public String goodRemove(@RequestParam(required = false) Long cartId) {
        cartService.goodRemove(cartId);
        request.setAttribute("allCarts", cartService.getAllCarts());
        request.setAttribute("totalAmount",cartService.getTotalAmount(cartService.getAllCarts()));
        return "cartPage";
    }

}
