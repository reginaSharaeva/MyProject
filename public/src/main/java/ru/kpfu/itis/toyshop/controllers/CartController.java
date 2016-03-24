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
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private CartService cartService;

    /**
     * Добавление товара в корзину
     *
     * @param cartGoodId id товара
     */
    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addInCart(Long cartGoodId, Long userId) {
        cartService.addInCart(cartGoodId, userId);
        return "added";
    }

}
