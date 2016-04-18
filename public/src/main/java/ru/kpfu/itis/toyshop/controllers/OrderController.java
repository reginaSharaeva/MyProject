package ru.kpfu.itis.toyshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.SecurityNamespaceHandler;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kpfu.itis.toyshop.aspects.annotations.IncludeMenuList;
import ru.kpfu.itis.toyshop.domain.*;
import ru.kpfu.itis.toyshop.form.OrderFormBean;
import ru.kpfu.itis.toyshop.security.MyUserDetail;
import ru.kpfu.itis.toyshop.sender.Mailing;
import ru.kpfu.itis.toyshop.service.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.Date;
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
    private AddressService addressService;

    @Autowired
    private OrderGoodService orderGoodService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    public static final String ATTR_ORDER_FORM = "orderForm";

    @IncludeMenuList
    @RequestMapping(method = RequestMethod.GET)
    public String renderToyView() {
        User user = userService.getUserByLogin((String) session.getAttribute("userLogin"));
        List<Cart> carts = (List<Cart>) session.getAttribute("allCarts");
        if (carts != null) {
            for (Cart cart: carts) {
                cartService.addInCart(cart.getGoods().getId(), user);
            }
            session.setAttribute("allCarts", null);
        }
        request.setAttribute(ATTR_ORDER_FORM, new OrderFormBean());
        return "orderPage";
    }

    @IncludeMenuList
    @RequestMapping(method = RequestMethod.POST)
    public String registrationForm(
            @Valid @ModelAttribute(ATTR_ORDER_FORM) OrderFormBean orderFormBean,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "orderPage";
        }
        Address address = new Address();
        address.setArea(orderFormBean.getArea());
        address.setCity(orderFormBean.getCity());
        address.setStreet(orderFormBean.getStreet());
        address.setHouse(Integer.parseInt(orderFormBean.getHouse()));
        address.setFlat(Integer.parseInt(orderFormBean.getFlat()));
        address.setIndex(orderFormBean.getIndex());

        addressService.addAddress(address);

        User user = userService.getUserByLogin((String) session.getAttribute("userLogin"));
        List<Cart> carts = cartService.getCartByUser(user);

        Order order = new Order();
        order.setCreate_time(new Date(System.currentTimeMillis()));
        order.setPay_type(orderFormBean.getPayWay());
        order.setStatus("Оформлен");
        order.setTotal_count((Long) session.getAttribute("totalCount"));
        order.setTotal_sum((BigDecimal) session.getAttribute("totalAmount"));
        order.setAddress(address);
        order.setUsers(user);

        orderService.saveOrder(order);

        for (Cart cart : carts) {
            cartService.deleteCart(cart);
            orderGoodService.addGood(cart, order);
        }
        List<Order_Good> order_goods = orderGoodService.getGoodsByOrder(order);
        String s = "";
        for (Order_Good order_good: order_goods) {
            s += order_good.getGoods().getName() + " " + order_good.getCount() + "шт." + "\n";
        }
        Mailing mailing = new Mailing();
        mailing.sendMail(user.getLogin(), "Order", "Ваш заказ оформлен!\n" +  s);
        return "main_page";
    }
}
