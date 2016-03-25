package ru.kpfu.itis.toyshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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

}
