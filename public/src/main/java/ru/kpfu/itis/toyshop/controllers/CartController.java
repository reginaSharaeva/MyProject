package ru.kpfu.itis.toyshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.kpfu.itis.toyshop.aspects.annotations.IncludeMenuList;
import ru.kpfu.itis.toyshop.domain.Cart;
import ru.kpfu.itis.toyshop.service.CartService;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

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
    @IncludeMenuList
    @RequestMapping(method = RequestMethod.GET)
    public String renderCart() {
        List<Cart> carts = cartService.getAllCarts();
        request.setAttribute("allCarts", carts);
        request.setAttribute("totalAmount",cartService.getTotalAmount(carts));
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

    @IncludeMenuList
    @RequestMapping(value = "/less", method = RequestMethod.POST)
    public String countLess(@RequestParam(required = false) Long cartId) {
        Cart cart = cartService.getCartById(cartId);
        List<Cart> carts = cartService.getAllCarts();
        if (cart.getCount() >= 1) {
            cartService.doCountLess(cart);
            for (Cart c : carts) {
                if (c.getId().equals(cartId)) {
                    c.setCount(c.getCount() - 1);
                }
            }
        }
        request.setAttribute("allCarts", carts);
        request.setAttribute("totalAmount", cartService.getTotalAmount(carts));
        return "cartPage";
    }

    @IncludeMenuList
    @RequestMapping(value = "/more", method = RequestMethod.POST)
    public String countMore(@RequestParam(required = false) Long cartId) {
        Cart cart = cartService.getCartById(cartId);
        List<Cart> carts = cartService.getAllCarts();
        if (cart.getCount() < 20) {
            cartService.doCountMore(cart);
            for (Cart c : carts) {
                if (c.getId().equals(cartId)) {
                    c.setCount(c.getCount() + 1);
                }
            }
        }
        request.setAttribute("allCarts", carts);
        request.setAttribute("totalAmount",cartService.getTotalAmount(carts));
        return "cartPage";
    }

    @IncludeMenuList
    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public String goodRemove(@RequestParam(required = false) Long cartId) {
        cartService.goodRemove(cartId);
        List<Cart> carts = cartService.getAllCarts();
        request.setAttribute("allCarts", carts);
        request.setAttribute("totalAmount",cartService.getTotalAmount(carts));
        return "cartPage";
    }

}
