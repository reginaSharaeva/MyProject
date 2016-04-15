package ru.kpfu.itis.toyshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kpfu.itis.toyshop.aspects.annotations.IncludeMenuList;
import ru.kpfu.itis.toyshop.domain.Cart;
import ru.kpfu.itis.toyshop.domain.User;
import ru.kpfu.itis.toyshop.form.OrderFormBean;
import ru.kpfu.itis.toyshop.service.CartService;
import ru.kpfu.itis.toyshop.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Регина on 03.04.2016.
 */
@Controller
@RequestMapping(value = "/order")
public class OrderController {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private HttpSession session;

    @Autowired
    private CartService cartService;

    @Autowired
    private UserService userService;

    public static final String ATTR_REGISTRATION_FORM = "orderForm";

    @IncludeMenuList
    @RequestMapping(method = RequestMethod.GET)
    public String renderToyView(@RequestParam(value = "totalAmount", required = false) BigDecimal totalAmount) {
        List<Cart> carts = (List<Cart>) session.getAttribute("allCarts");
        if (totalAmount != null) {
            cartService.checkCarts(carts, null);
            request.setAttribute("orders", "orders");
            return "loginPage";
        }
        cartService.checkCarts(carts, (String) session.getAttribute("userLogin"));
        request.setAttribute(ATTR_REGISTRATION_FORM, new OrderFormBean());
        return "orderPage";
    }

    @IncludeMenuList
    @RequestMapping(method = RequestMethod.POST)
    public String registrationForm(
            @Valid @ModelAttribute(ATTR_REGISTRATION_FORM) OrderFormBean orderFormBean,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "orderPage";
        }
        return "main_page";
    }
}
