package ru.kpfu.itis.toyshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kpfu.itis.toyshop.aspects.annotations.IncludeMenuList;
import ru.kpfu.itis.toyshop.domain.Cart;
import ru.kpfu.itis.toyshop.domain.User;
import ru.kpfu.itis.toyshop.service.CartService;
import ru.kpfu.itis.toyshop.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Regina on 28.12.2015.
 */
@Controller
public class MainController extends BaseController {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private UserService userService;

    @Autowired
    private CartService cartService;

    @Autowired
    private HttpSession session;

    @IncludeMenuList
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String renderMainPage() {
        String key = request.getParameter("key");
        String id = request.getParameter("id");
        if (key != null && id != null) {
            User user = userService.getUserById(Long.parseLong(id));
            if (user.getKey().equals(key)) {
                userService.changeCheck(user.getId());
            } else {
                return "registration/error_page";
            }
        }
        String login = (String) session.getAttribute("userLogin");
        List<Cart> carts = (List<Cart>) session.getAttribute("allCarts");
        if (login != null && carts != null) {
            User user = userService.getUserByLogin((String) session.getAttribute("userLogin"));
            for (Cart cart: carts) {
                cartService.addInCart(cart.getGoods().getId(), user);
            }
        }
        return "main_page";
    }
}
